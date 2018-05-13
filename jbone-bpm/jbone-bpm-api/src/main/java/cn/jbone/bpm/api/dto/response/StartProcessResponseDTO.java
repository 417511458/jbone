package cn.jbone.bpm.api.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 启动流程响应
 */
@Data
public class StartProcessResponseDTO implements Serializable {

    /**
     * 流程实例Id
     */
    private String processInstanceId;

    /**
     * 流程名称
     */
    private String processName;

    /**
     * 启动时间
     */
    private Date startTime;

    /**
     * 流程发起人
     */
    private String owner;

    /**
     * 业务主键
     * */
    private String businessKey;

}
