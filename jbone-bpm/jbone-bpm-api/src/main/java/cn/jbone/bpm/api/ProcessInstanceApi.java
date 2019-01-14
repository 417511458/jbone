package cn.jbone.bpm.api;

import cn.jbone.bpm.api.dto.request.ReactiveProcessRequestDTO;
import cn.jbone.bpm.api.dto.request.StartProcessRequestDTO;
import cn.jbone.bpm.api.dto.request.StopProcessRequestDTO;
import cn.jbone.bpm.api.dto.request.SuspendProcessRequestDTO;
import cn.jbone.bpm.api.dto.response.StartProcessResponseDTO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 流程实例API
 */
@RequestMapping("/processInstance")
public interface ProcessInstanceApi {

    /**
     * 启动流程
     * @param startProcessRequestDTO 启动流程业务Bean
     * @return 流程基本信息
     */
    @RequestMapping("start")
    Result<StartProcessResponseDTO> startProcess(StartProcessRequestDTO startProcessRequestDTO);

    /**
     * 终止流程
     * @param stopProcessRequestDTO 终止流程DTO
     * @return 终止结果
     */
    @RequestMapping("stop")
    Result<Void> stopProcess(StopProcessRequestDTO stopProcessRequestDTO);

    /**
     * 挂起流程
     * @param suspendProcessRequestDTO 挂起流程DTO
     * @return 挂起结果
     */
    @RequestMapping("suspend")
    Result<Void> suspendProcess(SuspendProcessRequestDTO suspendProcessRequestDTO);

    /**
     * 激活流程
     * @param reactiveProcessRequestDTO 激活流程DTO
     * @return 激活流程结果
     */
    @RequestMapping("reactive")
    Result<Void> reactiveProcess(ReactiveProcessRequestDTO reactiveProcessRequestDTO);



}
