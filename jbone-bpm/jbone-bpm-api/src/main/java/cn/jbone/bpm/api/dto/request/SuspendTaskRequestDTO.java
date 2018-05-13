package cn.jbone.bpm.api.dto.request;

import lombok.Data;

/**
 * 挂起任务DTO
 */
@Data
public class SuspendTaskRequestDTO {
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 操作人
     */
    private String operator;
}
