package cn.jbone.bpm.core.service.vo.processinstance;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProcessInstanceVo implements Serializable {
    private String businessKey;
    private String processInstanceId;
    private String processInstanceName;
    private String processDefinitionKey;
    private Date startTime;
    private Date endTime;
    private String owner;
}
