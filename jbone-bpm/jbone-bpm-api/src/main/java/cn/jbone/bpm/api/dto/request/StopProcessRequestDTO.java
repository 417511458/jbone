package cn.jbone.bpm.api.dto.request;

import lombok.Data;

/**
 * 终止流程DTO
 */
@Data
public class StopProcessRequestDTO {
    /**
     * 操作者
     */
    private String operator;
    /**
     * 流程实例ID
     */
    private String processInstanceId;
    /**
     * 终止原因
     */
    private String reason;
}
