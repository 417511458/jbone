package cn.jbone.bpm.core.service;

import cn.jbone.bpm.api.dto.request.ReactiveProcessRequestDTO;
import cn.jbone.bpm.api.dto.request.StartProcessRequestDTO;
import cn.jbone.bpm.api.dto.request.StopProcessRequestDTO;
import cn.jbone.bpm.api.dto.request.SuspendProcessRequestDTO;
import cn.jbone.bpm.api.dto.response.StartProcessResponseDTO;
import cn.jbone.common.exception.JboneException;
import org.flowable.engine.HistoryService;
import org.flowable.engine.IdentityService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.history.HistoricProcessInstanceQuery;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProcessInstanceService {
    @Autowired
    private HistoryService historyService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private IdentityService identityService;

    public void list(){
        HistoricProcessInstanceQuery processInstanceQuery = historyService.createHistoricProcessInstanceQuery();
        processInstanceQuery.finished();
    }

    public StartProcessResponseDTO startProcess(StartProcessRequestDTO startProcessRequestDTO) {
        // 流程定义检查
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionKey(startProcessRequestDTO.getProcessDefinitionKey()).latestVersion()
                .singleResult();

        if (processDefinition == null) {
            throw new JboneException("流程模型[" + startProcessRequestDTO.getProcessDefinitionKey() + "]尚未发布或不可用");
        }
        if (processDefinition.isSuspended()) {
            throw new JboneException("流程模型[" + startProcessRequestDTO.getProcessDefinitionKey() + "]已挂起，不能发布新流程。");
        }

        // 设置流程启动人
        identityService.setAuthenticatedUserId(startProcessRequestDTO.getOperator());

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(startProcessRequestDTO.getProcessDefinitionKey(),startProcessRequestDTO.getFormId(),startProcessRequestDTO.getVariables());
        if(processInstance == null){
            throw new JboneException("流程发布失败。");
        }

        StartProcessResponseDTO responseDTO = new StartProcessResponseDTO();
        responseDTO.setProcessInstanceId(processInstance.getProcessInstanceId());
        responseDTO.setProcessName(processInstance.getName());
        responseDTO.setStartTime(processInstance.getStartTime());
        responseDTO.setOwner(processInstance.getStartUserId());
        responseDTO.setBusinessKey(processInstance.getBusinessKey());
        return responseDTO;
    }

    public void stopProcess(StopProcessRequestDTO stopProcessRequestDTO){
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(stopProcessRequestDTO.getProcessInstanceId()).singleResult();
        if(processInstance == null){
            throw new JboneException("流程不存在或已结束。");
        }

        identityService.setAuthenticatedUserId(stopProcessRequestDTO.getOperator());

        runtimeService.deleteProcessInstance(stopProcessRequestDTO.getProcessInstanceId(),stopProcessRequestDTO.getReason());
    }

    public void suspendProcess(SuspendProcessRequestDTO suspendProcessRequestDTO){
        historyService.createHistoricDetailQuery().processInstanceId("").singleResult();
    }

    public void reactiveProcess(ReactiveProcessRequestDTO reactiveProcessRequestDTO){

    }
}
