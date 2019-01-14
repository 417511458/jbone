package cn.jbone.cms.core.dao.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 专题栏目目录
 */
@Data
@Entity
@Table(name = "category_toc")
public class CategoryToc extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "category_toc", initialValue = 1000)
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
     * 子目录
     */
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name = "pid")
    private List<CategoryToc> childCategoryToc;

    /**
     * 所属栏目
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * 关联文章
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

}
