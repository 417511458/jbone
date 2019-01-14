package cn.jbone.cms.common.enums;

public enum StatusEnum {

    DELETE("已删除"),

    PUBLISH("已发布"),

    AUDIT("审核中");

    private String name;

    StatusEnum( String name) {
        this.name = name;
    }


}
