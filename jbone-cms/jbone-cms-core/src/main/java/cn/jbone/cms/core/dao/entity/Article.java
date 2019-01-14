package cn.jbone.cms.core.dao.entity;

import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "article")
public class Article extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "article", initialValue = 1000)
    private Long id;

    /**
     * 标题
     */
    @Column(name = "title")
    private String title;

    /**
     * 封面图
     */
    @Column(name = "front_cover")
    private String frontCover;

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
     * 点击量
     */
    @Column(name = "hits")
    private int hits;

    /**
     * 文章状态，枚举,默认发布状态
     */
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.PUBLISH;

    /**
     * 是否允许评论
     */
    @Column(name = "allow_comment")
    @Enumerated(EnumType.ORDINAL)
    private BooleanEnum allowComment;

    /**
     * 文章内容，双向关联
     */
    @OneToOne(targetEntity = ArticleData.class,mappedBy = "article",fetch=FetchType.LAZY)
    private ArticleData articleData;

    /**
     * 栏目
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    /**
     * 文章模版
     */
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "template_id",referencedColumnName = "id")
    private Template template;

    /**
     * 文章标签
     */
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name = "article_tag",joinColumns = @JoinColumn(name = "article_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name = "tag_id",referencedColumnName = "id"))
    private List<Tag> tags;

}
