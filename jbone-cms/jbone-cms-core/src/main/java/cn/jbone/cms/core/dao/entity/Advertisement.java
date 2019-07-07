package cn.jbone.cms.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "advertisement",indexes = {@Index(name = "advertisement_index_site_id",columnList = "site_id")})
public class Advertisement extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "advertisement", initialValue = 1000)
    private Long id;

    /**
     * 广告位，取自字典
     */
    @Column(name = "location")
    private String location;

    /**
     * 广告类型，取自字典
     */
    @Column(name = "type")
    private String type;

    /**
     * 广告名字
     */
    @Column(name = "name")
    private String name;

    /**
     * 广告代码内容
     */
    @Column(name = "content",length = 1024)
    private String content;

    /**
     * 广告图片内容
     */
    @Column(name = "img",length = 1024)
    private String img;

    /**
     * 广告文本
     */
    @Column(name = "text",length = 1024)
    private String text;

    /**
     * 超链接
     */
    @Column(name = "url")
    private String url;

    /**
     * 状态
     */
    @Column(name = "enable")
    private int enable;

    /**
     * 点击数
     */
    @Column(name = "hits")
    private int hits;

    /**
     * 站点ID
     */
    @Column(name = "site_id")
    private Integer siteId;
}
