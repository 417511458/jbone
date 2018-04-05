package cn.jbone.eb.portal.core.service.bo.indexmoduleconfig;

import lombok.Data;

@Data
public class IndexModuleConfigBO {
    private int id;
    private String name;
    private int type;
    private Integer categoryId;
    private Integer industryId;
    private String description;
    private int sortType;
    private int sortNum;
    private int status;
    private String operator;
}
