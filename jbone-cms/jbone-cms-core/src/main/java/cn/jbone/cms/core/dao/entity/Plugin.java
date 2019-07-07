package cn.jbone.cms.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "plugin",indexes = {@Index(name = "plugin_index_site_id",columnList = "site_id")})
public class Plugin extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "plugin", initialValue = 1000)
    private Integer id;

    /**
     * 插件名字
     */
    @Column(name = "name")
    private String name;

    /**
     * 插件类型
     */
    @Column(name = "type")
    private String type;

    /**
     * 插件内容
     */
    @Column(name = "content",columnDefinition="text")
    private String content;

    /**
     * 是否启用: 1,启用，0，关闭
     */
    @Column(name = "enable")
    private int enable;

    /**
     * 排序号
     */
    @Column(name = "orders")
    private int orders;

    /**
     * 站点ID
     */
    @Column(name = "site_id")
    private Integer siteId;

}
