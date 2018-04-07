package cn.jbone.eb.manager.core.service.bo.operation;

import lombok.Data;

@Data
public class OperationBaseInfoBO {
    private int id;
    private int type;
    private String title;
    private String imgUrl;
    private String linkUrl;
    private String description;
    private int sortNum;
    private int status;
    private String operator;
}
