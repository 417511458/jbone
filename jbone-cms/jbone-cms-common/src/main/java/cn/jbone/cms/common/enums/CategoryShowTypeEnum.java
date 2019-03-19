package cn.jbone.cms.common.enums;

/**
 * 栏目展示
 */
public enum CategoryShowTypeEnum {

    LIST("列表展示"),

    FIRSTARTICLE("第一篇文章");

    private String name;

    CategoryShowTypeEnum(String name) {
        this.name = name;
    }
}
