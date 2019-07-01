package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class SiteDO {
    private Integer id;

    /**
     * 网站名称
     */
    private String name;

    /**
     * 网站描述
     */
    private String description;

    /**
     * 域名
     */
    private String domain;

    /**
     * 父级网站ID,用于解决多网站域名映射一个站点，如www.jbone.cn和jbone.cn是同一个
     */
    private int pid;

    /**
     * 序号
     */
    private int orders;

    /**
     * 站点使用的模版
     */
    private long templateId;

    /**
     * 是否启用: 1,启用，0，关闭
     */
    private int enable;
}
