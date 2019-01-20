package cn.jbone.cms.common.module.article;

import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDO {

    private Long id;

    /**
     * 父级栏目
     */
    private int pid;

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
     * 子栏目
     */
    private List<CategoryDO> childCategory;

    /**
     * 关键字，用于SEO
     */
    private String keywords;

    /**
     * 描述，摘要，用于SEO和列表摘要
     */
    private String description;

    /**
     * 文章分类
     */
    private CategoryTypeEnum type;

    /**
     * 是否展示在导航条上
     */
    private BooleanEnum inMenu;

    /**
     * 状态，枚举,默认发布状态
     */
    private StatusEnum status = StatusEnum.PUBLISH;

    /**
     * 模版
     */
    private TemplateDO template;

    /**
     * 栏目标签，只用于标签虚拟栏目
     */
    private List<TagDO> tags;
}
