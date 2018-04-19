package cn.jbone.bpm.api.dto.response;

import lombok.Data;

import java.util.Date;

/**
 * 任务基本信息
 */
@Data
public class TaskInstanceBaseInfoResponseDTO {
    private String id;                          //待办Id
    private String name;                        //待办名字
    private String processInstanceId;			//流程实例
    private String taskDefinitionKey;			//待办定义
    private int priority;						//优先级
    private String owner;						//所有者
    private String assignee;					//申领人
    private String processDefinitionKey;		//流程定义
    private String processName;                 //流程名字
    private Date createTime;					//创建时间
    private Date dueDate;						//过期时间
    private String isSuspended;					//是否挂起
}
