package cn.jbone.cms.core.dao.entity;

import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "category", initialValue = 1000)
    private Long id;

    /**
     * 父级栏目
     */
    @Column(name = "pid")
    private int pid;

    /**
     * 栏目标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 栏目外链（如果是外部URL）
     */
    @Column(name = "url")
    private String url;

    /**
     * 目标
     */
    @Column(name = "target")
    private String target;

    /**
     * 排序
     */
    @Column(name = "orders")
    private int orders;

    /**
     * 封面图
     */
    @Column(name = "front_cover")
    private String frontCover;

    /**
     * 子栏目
     */
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "pid")
    private List<Category> childCategory;

    /**
     * 关键字，用于SEO
     */
    @Column(name = "keywords")
    private String keywords;

    /**
     * 描述，摘要，用于SEO和列表摘要
     */
    @Column(name = "description")
    private String description;

    /**
     * 文章分类
     */
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CategoryTypeEnum type;

    /**
     * 是否展示在导航条上
     */
    @Column(name = "in_menu")
    @Enumerated(EnumType.ORDINAL)
    private BooleanEnum inMenu;

    /**
     * 状态，枚举,默认发布状态
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.PUBLISH;

    /**
     * 模版
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "template_id",referencedColumnName = "id")
    private Template template;

    /**
     * 栏目标签，只用于标签虚拟栏目
     */
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "category_tag",joinColumns = @JoinColumn(name = "category_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id"))
    private List<Tag> tags;
}
