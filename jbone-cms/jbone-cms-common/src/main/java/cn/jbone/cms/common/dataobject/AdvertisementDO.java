package cn.jbone.cms.common.dataobject;

import lombok.Data;

@Data
public class AdvertisementDO {
    private Long id;

    /**
     * 广告位，取自字典
     */
    private String location;

    /**
     * 广告类型，取自字典
     */
    private String type;

    /**
     * 广告名字
     */
    private String name;

    /**
     * 广告内容
     */
    private String content;

    /**
     * 超链接
     */
    private String url;

    /**
     * 状态
     */
    private int enable;

    /**
     * 点击数
     */
    private int hits;

    /**
     * 广告图片内容
     */
    private String img;

    /**
     * 广告文本
     */
    private String text;

    private InnerDictionaryItemDO typeDetail;
    private InnerDictionaryItemDO locationDetail;

    private Integer siteId;

    private int creator;
}
