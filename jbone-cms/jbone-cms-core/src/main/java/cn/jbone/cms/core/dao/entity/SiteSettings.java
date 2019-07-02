package cn.jbone.cms.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 站点设置表
 */
@Data
@Entity
@Table(name = "site_settings",indexes = {@Index(name = "site_settings_index_siteid",columnList = "site_id")})
public class SiteSettings extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "site_settings", initialValue = 1000)
    private Long id;

    /**
     * 站点ID
     */
    @Column(name = "site_id",nullable = false)
    private Integer siteId;

    /**
     * 设置名，如title
     */
    @Column(name = "name",nullable = false)
    private String name;

    /**
     * 值
     */
    @Column(name = "value")
    private String value;







}
