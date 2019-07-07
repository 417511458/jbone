package cn.jbone.cms.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tag",indexes = {@Index(name = "tag_index_site_id",columnList = "site_id")})
public class Tag extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "tag", initialValue = 1000)
    private Long id;

    /**
     * 标签名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 站点ID
     */
    @Column(name = "site_id")
    private Integer siteId;
}
