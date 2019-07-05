package cn.jbone.cms.common.dataobject;

import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import lombok.Data;

import java.util.List;

@Data
public class ArticleDO {

    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 封面图
     */
    private String frontCover;

    /**
     * 关键字，用于SEO
     */
    private String keywords;

    /**
     * 描述，摘要，用于SEO和列表摘要
     */
    private String description;

    /**
     * 点击量
     */
    private int hits = 0;

    /**
     * 评论数
     */
    private long commentCount = 0;

    private int orders = 0;

    /**
     * 文章状态，枚举,默认发布状态
     */
    private StatusEnum status = StatusEnum.PUBLISH;

    /**
     * 是否允许评论
     */
    private BooleanEnum allowComment;

    /**
     * 栏目
     */
    private CategoryDO category;

    /**
     * 文章模版
     */
    private TemplateDO template;

    /**
     * 文章标签
     */
    private List<TagDO> tags;

    /**
     * 标签ID集合
     */
    private List<Long> tagIds;

    /**
     * 文章内容
     */
    private ArticleDataDO articleData;

    /**
     * 作者ID
     */
    private Integer creator;

    private Long addTime;

    private Long updateTime;

    private String addTimeText;

    private String updateTimeText;

    private Integer siteId;
}
