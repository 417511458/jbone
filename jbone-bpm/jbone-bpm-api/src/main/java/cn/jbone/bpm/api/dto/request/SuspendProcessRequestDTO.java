package cn.jbone.bpm.api.dto.request;

import lombok.Data;

/**
 * 挂起流程DTO
 */
@Data
public class SuspendProcessRequestDTO {
    /**
     * 操作者
     */
    private String operator;
    /**
     * 流程实例ID
     */
    private String processInstanceId;
    /**
     * 挂起原因
     */
    private String reason;
}
