package cn.jbone.eb.portal.core.service.bo.operationposition;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class OperationPostionBaseInfoBO {
    private int id;
    private int type;
    private String title;
    private int status;
    private String operator;
    private Timestamp addTime;
    private Timestamp updateTime;
}
