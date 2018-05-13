package cn.jbone.bpm.api.dto.response;

import cn.jbone.bpm.api.enums.ProcessInstanceStatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * 流程实例基本信息
 */
@Data
public class ProcessInstanceBaseInfoResponseDTO {
    /**
     * 流程实例ID
     */
    private String id;
    /**
     * 流程名字
     */
    private String name;
    /**
     * 流程定义key
     */
    private String definitionKey;
    /**
     * 流程所有者
     */
    private String owner;
    /**
     * 流程创建时间
     */
    private Date createTime;
    /**
     * 流程过期时间
     */
    private Date dueDate;
    /**
     * 流程关闭时间
     */
    private Date closeTime;
    /**
     * 流程状态
     */
    private ProcessInstanceStatusEnum status;
}

