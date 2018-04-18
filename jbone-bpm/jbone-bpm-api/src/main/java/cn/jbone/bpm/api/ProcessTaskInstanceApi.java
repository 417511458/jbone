package cn.jbone.bpm.api;

import cn.jbone.bpm.api.dto.request.*;
import cn.jbone.bpm.api.dto.response.TaskInstanceResponseDTO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 流程任务实例API
 */
@RequestMapping("/processTaskInstance")
public interface ProcessTaskInstanceApi {

    /**
     * 申领任务
     * @param claimTaskRequestDTO 申领任务DTO
     * @return 返回任务实例
     */
    @RequestMapping("/claim")
    Result<TaskInstanceResponseDTO> claimTask(ClaimTaskRequestDTO claimTaskRequestDTO);

    /**
     * 完成审批任务
     * @param completeTaskRequestDTO 完成任务DTO
     * @return 返回任务DTO
     */
    @RequestMapping("/complete")
    Result<TaskInstanceResponseDTO> completeTask(CompleteTaskRequestDTO completeTaskRequestDTO);

    /**
     * 申领并完成审批任务
     * @param claimAndCompleteTaskRequestDTO 完成任务DTO
     * @return 返回任务DTO
     */
    @RequestMapping("/claimAndComplete")
    Result<TaskInstanceResponseDTO> claimAndCompleteTask(ClaimAndCompleteTaskRequestDTO claimAndCompleteTaskRequestDTO);

    /**
     * 挂起任务
     * @param suspendTaskRequestDTO 挂起任务DTO
     * @return
     */
    @RequestMapping("/suspend")
    Result<Void> suspendTask(SuspendTaskRequestDTO suspendTaskRequestDTO);

    /**
     * 恢复已挂起的任务
     * @param reactiveTaskRequestDTO 恢复任务DTO
     * @return
     */
    @RequestMapping("/reactive")
    Result<Void> reactiveTask(ReactiveTaskRequestDTO reactiveTaskRequestDTO);

    /**
     * 跳转任务(非标准审批)
     * @param skipTaskRequestDTO 跳转任务DTO
     * @return
     */
    @RequestMapping("/skip")
    Result<Void> skipTask(SkipTaskRequestDTO skipTaskRequestDTO);
}
