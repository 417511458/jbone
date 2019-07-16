package cn.jbone.cms.core.dao.entity;

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
     * 模版类型:企业宣传、个人博客、开源项目、政府官网、电子商务、bbs
     */
    @Column(name = "type")
    private String type;

    /**
     * 风格：简约 / 唯美
     */
    @Column(name = "style")
    private String style;

    /**
     * 色系：蓝色 / 红色 / 绿色 / 黄色
     */
    @Column(name = "color")
    private String color;

    /**
     * 状态：1启用，0禁用
     */
    @Column(name = "enable")
    private int enable;

    /**
     * 是否单页模版，1：单页，0：多页
     */
    @Column(name = "single_page")
    private int singlePage;

    /**
     * 数据收集器，以逗号隔开
     */
    @Column(name = "data_collectors",length = 2048)
    private String dataCollectors;


}
