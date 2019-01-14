package cn.jbone.cms.common.enums;

/**
 * 模版类型
 */
public enum TemplateTypeEnum {

    NORMAL_CATEGORY("普通分类栏目模版"),

    TAG_CATEGORY("TAG标签虚拟栏目模版"),

    SPECIAL_CATEGORY("专题栏目模版"),

    ARTICLE("文章模版");

    private String name;

    TemplateTypeEnum(String name) {
        this.name = name;
    }
}
