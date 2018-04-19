package cn.jbone.bpm.api.dto.request;

import lombok.Data;

import java.util.Map;

/**
 * 跳转任务请求，用于动态跳转流程(非标准审批)
 */
@Data
public class SkipTaskRequestDTO {

    /**
     * 任务ID
     */
    private String taskId;

    /**
     * 目标节点key
     */
    private String targetNode;

    /**
     * 跳转原因
     */
    private String reason;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 流程变量
     */
    private Map<String, Object> variables;
}
