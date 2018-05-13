package cn.jbone.bpm.api.dto.request;

import cn.jbone.bpm.api.enums.MyTaskStatusEnum;
import lombok.Data;

import java.util.List;

@Data
public class QueryMyTaskRequestDTO {
    /**
     * 当前人
     */
    private String username;
    /**
     * 任务状态，（申领、未申领、已挂起）
     */
    private List<MyTaskStatusEnum> status;

    /**
     * 流程实例ID
     */
    private String processInstanceId;

    /**
     * 流程定义key
     */
    private String processDefinitionKey;

}
