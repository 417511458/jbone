package cn.jbone.cms.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "site",uniqueConstraints = {@UniqueConstraint(columnNames="domain"),@UniqueConstraint(columnNames="alias1"),@UniqueConstraint(columnNames="alias2")})
public class Site extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "site", initialValue = 1000)
    private Integer id;

    /**
     * 网站名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 网站描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 域名
     */
    @Column(name = "domain")
    private String domain;

    /**
     * 域别名,用于解决多网站域名映射一个站点，如www.jbone.cn和jbone.cn是同一个
     */
    @Column(name = "alias1")
    private String alias1;

    /**
     * 域别名,用于解决多网站域名映射一个站点，如www.jbone.cn和jbone.cn是同一个
     */
    @Column(name = "alias2")
    private String alias2;

    /**
     * 父级网站ID,
     */
    @Column(name = "pid")
    private int pid;

    /**
     * 序号
     */
    @Column(name = "orders")
    private int orders;

    /**
     * 站点使用的模版
     */
    @Column(name = "template_id")
    private long templateId;

    /**
     * 是否启用: 1,启用，0，关闭,-1 已删除
     */
    @Column(name = "enable")
    private int enable;
}
