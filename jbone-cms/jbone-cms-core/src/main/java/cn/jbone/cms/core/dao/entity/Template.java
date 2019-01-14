package cn.jbone.cms.core.dao.entity;

import cn.jbone.cms.common.enums.TemplateTypeEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "template")
public class Template extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "template", initialValue = 1000)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "name")
    private String name;

    /**
     * 模版编码，对应于前端的模版目录
     */
    @Column(name = "code")
    private String code;

    /**
     * 封面图
     */
    @Column(name = "front_cover")
    private String frontCover;

    /**
     * 图片
     */
    @Column(name = "images")
    private String images;

    /**
     * 描述，摘要
     */
    @Column(name = "description")
    private String description;

    /**
     * 模版类型
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TemplateTypeEnum type;
}
