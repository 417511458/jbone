package cn.jbone.bpm.api.dto.response;

import lombok.Data;

@Data
public class ProcessInstanceQueryRequestDTO {

    /**
     * 流程实例ID
     */
    private String processInstanceId;

    /**
     * 流程所有者
     */
    private String owner;
}
