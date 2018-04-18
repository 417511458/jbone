package cn.jbone.bpm.api.dto.response;

import lombok.Data;

import java.io.Serializable;

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
}
