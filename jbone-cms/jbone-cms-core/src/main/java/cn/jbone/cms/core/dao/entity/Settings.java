package cn.jbone.cms.core.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "settings",uniqueConstraints = {@UniqueConstraint(columnNames="setting_key")})
public class Settings extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "settings", initialValue = 1000)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "setting_key")
    private String settingKey;

    /**
     * 封面图
     */
    @Column(name = "setting_value")
    private String settingValue;

    /**
     * 描述，用于功能介绍
     */
    @Column(name = "description")
    private String description;


}
