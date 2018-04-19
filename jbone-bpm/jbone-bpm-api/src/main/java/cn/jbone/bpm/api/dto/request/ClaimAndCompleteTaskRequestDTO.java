package cn.jbone.bpm.api.dto.request;

import cn.jbone.bpm.api.enums.TaskAuditEnum;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 完成任务DTO
 */
@Data
public class ClaimAndCompleteTaskRequestDTO {
    private String processInstanceId;	//流程实例ID
    private String taskId;				//任务ID
    private String taskDefinitionKey;   //任务Key
    private TaskAuditEnum audit;				//审核意见(pass/reject)
    private String reason;				//原因说明
    private String selectUser;			//指定下一步办理人
    private String operator;			//当前办理人
    private int priority;			    //指定优先级
    private String isOverDue;			//是否过期
    private Date validDate;				//流程操作有效时间
    private Map<String,Object> variables = new HashMap<>();//流程运行时参数
}
