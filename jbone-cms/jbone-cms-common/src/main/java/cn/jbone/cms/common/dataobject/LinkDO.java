package cn.jbone.cms.common.dataobject;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LinkDO {

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面图
     */
    private String frontCover;

    /**
     * url
     */
    private String url;

    /**
     * 描述
     */
    private String description;

    /**
     * 排序
     */
    private int orders;

    /**
     * 添加时间
     */
    private Timestamp addTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;


    /**
     * 创建者
     */
    private Integer creator;

    private Integer siteId;
}
