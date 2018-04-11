package cn.jbone.eb.manager.core.service.vo.operation;

import lombok.Data;

@Data
public class CreateOperationVo {
    private int type;
    private String title;
    private String imgUrl;
    private String linkUrl;
    private String description;
    private int sortNum;
    private int status;
    private String operator;
}
