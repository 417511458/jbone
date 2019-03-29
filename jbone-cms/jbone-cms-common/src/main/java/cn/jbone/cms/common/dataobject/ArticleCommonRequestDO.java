package cn.jbone.cms.common.dataobject;

import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.common.dataobject.SearchListDO;
import cn.jbone.common.dataobject.SearchSortDO;
import lombok.Data;

import java.util.List;

@Data
public class ArticleCommonRequestDO extends SearchListDO {

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
    private List<StatusEnum> statusList;

    /**
     * 分类
     */
    private Long categoryId;

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

    public static int DEFAULT_SIZE = 10;

    public static ArticleCommonRequestDO build(){
        return build(1,DEFAULT_SIZE);
    }

    public static ArticleCommonRequestDO build(int pageNumber){
        return build(pageNumber,DEFAULT_SIZE);
    }

    public static ArticleCommonRequestDO build(int pageNumber,int pageSize){
        ArticleCommonRequestDO articleCommonRequestDO = new ArticleCommonRequestDO();
        articleCommonRequestDO.setPageNumber(pageNumber);
        articleCommonRequestDO.setPageSize(pageSize);
        articleCommonRequestDO.addSort(new SearchSortDO("addTime", SearchSortDO.Direction.DESC));
        return articleCommonRequestDO;
    }


    /**
     * 链表式构建
     */
    public ArticleCommonRequestDO id(Long id){
        this.id = id;
        return this;
    }

    public ArticleCommonRequestDO title(String title){
        this.title = title;
        return this;
    }

    public ArticleCommonRequestDO keywords(String keywords){
        this.keywords = keywords;
        return this;
    }

    public ArticleCommonRequestDO description(String description){
        this.description = description;
        return this;
    }

    public ArticleCommonRequestDO statusList(List<StatusEnum> statusList){
        this.statusList = statusList;
        return this;
    }

    public ArticleCommonRequestDO categoryId(Long categoryId){
        this.categoryId = categoryId;
        return this;
    }

    public ArticleCommonRequestDO templateId(Long templateId){
        this.templateId = templateId;
        return this;
    }

    public ArticleCommonRequestDO tagIds(List<Long> tagIds){
        this.tagIds = tagIds;
        return this;
    }

    public ArticleCommonRequestDO creator(Integer creator){
        this.creator = creator;
        return this;
    }

    public ArticleCommonRequestDO pageSize(int pageSize){
        super.setPageSize(pageSize);
        return this;
    }

    public ArticleCommonRequestDO pageNumber(int pageNumber){
        super.setPageNumber(pageNumber);
        return this;
    }

    private ArticleRequestConfigDO config = new ArticleRequestConfigDO();



}
