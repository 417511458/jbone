package cn.jbone.bpm.core.service.vo.processinstance;

import lombok.Data;

import java.util.Date;

@Data
public class ProcessInstanceListVo {
    private String processInstanceId;   //流程实例ID
    private String owner;               //流程发起人
    private String processDefinitionKey;//流程定义Key
    private String status;              //状态，正常active，结束stop
    private String processInstanceName; //流程名字
    private Date startedBefore;       //XXX之前启动
    private Date startedAfter;        //XXX之后启动
    private Date endBefore;           //XXX之前结束
    private Date endAfter;            //XXX之后结束
    private String orderBy;             //排序字段
    private String sort;                //排序规则


    public static final String ACTIVE_STATUS = "active";
    public static final String STOP_STATUS = "stop";
    public static final String SORT_ASC = "asc";  //正序
    public static final String SORT_DESC = "desc"; //倒叙
}
