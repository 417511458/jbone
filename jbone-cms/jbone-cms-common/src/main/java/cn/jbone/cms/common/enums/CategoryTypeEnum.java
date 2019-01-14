package cn.jbone.cms.common.enums;

/**
 * 栏目类型
 */
public enum  CategoryTypeEnum {

    CATEGORY("普通分类栏目"),

    TAG("TAG标签虚拟栏目"),

    SPECIAL("专题栏目");


    private String name;

    CategoryTypeEnum(String name) {
        this.name = name;
    }
}
