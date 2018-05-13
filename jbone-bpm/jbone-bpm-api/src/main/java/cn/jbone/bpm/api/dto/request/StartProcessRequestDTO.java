package cn.jbone.bpm.api.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * 启动流程DTO
 */
@Data
public class StartProcessRequestDTO implements Serializable {
    /**
     * 流程定义key
     */
    private String processDefinitionKey;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 业务主键
     */
    private String formId;

    /**
     * 流程变量
     */
    private Map<String, Object> variables;
}
