package cn.jbone.cms.common.dataobject.search;

import cn.jbone.cms.common.dataobject.config.ArticleFiledConfigDO;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.common.dataobject.SearchListDO;
import cn.jbone.common.dataobject.SearchSortDO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleSearchDO extends SearchListDO {

    /**
     * 文章ID
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 关键字，用于SEO
     */
    private String keywords;

    /**
     * 描述，摘要，用于SEO和列表摘要
     */
    private String description;

    /**
     * 文章状态，枚举,默认发布状态
     */
    private List<StatusEnum> statusList = new ArrayList<>();

    /**
     * 分类
     */
    private Long categoryId;

    /**
     * 分类
     */
    private List<Long> categoryIds;

    /**
     * 文章模版
     */
    private Long templateId;

    /**
     * 文章标签
     */
    private List<Long> tagIds;

    /**
     * 作者ID
     */
    private Integer creator;

    private Integer siteId;

    public static int DEFAULT_SIZE = 10;

    public static ArticleSearchDO build(){
        return build(1,DEFAULT_SIZE);
    }

    public static ArticleSearchDO build(int pageNumber){
        return build(pageNumber,DEFAULT_SIZE);
    }

    public static ArticleSearchDO build(int pageNumber, int pageSize){
        ArticleSearchDO articleSearchDO = new ArticleSearchDO();
        articleSearchDO.setPageNumber(pageNumber);
        articleSearchDO.setPageSize(pageSize);
        return articleSearchDO;
    }


    /**
     * 链表式构建
     */
    public ArticleSearchDO id(Long id){
        this.id = id;
        return this;
    }

    public ArticleSearchDO title(String title){
        this.title = title;
        return this;
    }

    public ArticleSearchDO keywords(String keywords){
        this.keywords = keywords;
        return this;
    }

    public ArticleSearchDO description(String description){
        this.description = description;
        return this;
    }

    public ArticleSearchDO statusList(List<StatusEnum> statusList){
        this.statusList = statusList;
        return this;
    }

    public ArticleSearchDO categoryId(Long categoryId){
        this.categoryId = categoryId;
        return this;
    }

    public ArticleSearchDO templateId(Long templateId){
        this.templateId = templateId;
        return this;
    }

    public ArticleSearchDO tagIds(List<Long> tagIds){
        this.tagIds = tagIds;
        return this;
    }

    public ArticleSearchDO creator(Integer creator){
        this.creator = creator;
        return this;
    }

    public ArticleSearchDO pageSize(int pageSize){
        super.setPageSize(pageSize);
        return this;
    }

    public ArticleSearchDO pageNumber(int pageNumber){
        super.setPageNumber(pageNumber);
        return this;
    }

    private ArticleFiledConfigDO config = new ArticleFiledConfigDO();



}
