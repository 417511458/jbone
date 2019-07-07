package cn.jbone.cms.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "link",indexes = {@Index(name = "link_index_site_id",columnList = "site_id")})
public class Link extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "link", initialValue = 1000)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 封面图
     */
    @Column(name = "front_cover")
    private String frontCover;

    /**
     * url
     */
    @Column(name = "url")
    private String url;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 点击量
     */
    @Column(name = "orders")
    private int orders;

    /**
     * 站点ID
     */
    @Column(name = "site_id")
    private Integer siteId;

}
