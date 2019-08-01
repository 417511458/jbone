package cn.jbone.cms.common.dataobject;


import lombok.Data;

import java.util.List;

/**
 * 专题栏目目录
 */
@Data
public class CategoryTocDO {
    private Long id;

    /**
     * 父级栏目
     */
    private long pid;

    /**
     * 栏目标题
     */
    private String title;

    /**
     * 栏目外链（如果是外部URL）
     */
    private String url;

    /**
     * 目标
     */
    private String target;

    /**
     * 排序
     */
    private int orders;

    /**
     * 封面图
     */
    private String frontCover;

    /**
     * 子目录
     */
    private List<CategoryTocDO> children;

    /**
     * 所属栏目
     */
    private CategoryDO category;

    /**
     * 关联文章
     */
    private ArticleDO article;

    private Long categoryId;

    private String type;

}
