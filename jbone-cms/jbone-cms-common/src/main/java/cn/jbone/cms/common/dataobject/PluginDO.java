package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class PluginDO {

    private int id;

    /**
     * 插件名字
     */
    private String name;

    /**
     * 插件类型
     */
    private String type;

    /**
     * 插件内容
     */
    private String content;

    /**
     * 是否启用: 1,启用，0，关闭
     */
    private int enable;

    /**
     * 排序号
     */
    private int orders;

    private Integer siteId;

    private InnerDictionaryItemDO pluginType;

    private Integer creator;
}
