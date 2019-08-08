package cn.jbone.cms.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 站点设置表
 */
@Data
@Entity
@Table(name = "site_settings",
        indexes = {@Index(name = "site_settings_index_siteid",columnList = "site_id")},
        uniqueConstraints = {
        @UniqueConstraint(name = "site_settings_uc_siteid_name",columnNames = {"site_id","name"})}
        )
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
     * 设置key，如title
     */
    @Column(name = "name",nullable = false)
    private String name;

    /**
     * 值
     */
    @Column(name = "value")
    private String value;

    /**
     * 提示文案
     */
    @Column(name = "prompt")
    private String prompt;

    /**
     * 数据类型
     */
    @Column(name = "data_type")
    private String dataType;







}
