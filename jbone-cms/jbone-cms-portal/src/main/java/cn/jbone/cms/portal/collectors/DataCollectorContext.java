package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import org.springframework.ui.ModelMap;

import java.io.Serializable;

public class DataCollectorContext implements Serializable {
    private ModelMap modelMap;
    private Integer siteId;
    private ArticleSearchDO articleRequestDO;
    private String page;

    public void addAttribute(String key,Object value){
        this.modelMap.addAttribute(key,value);
    }


    public static DataCollectorContext build(){
        return new DataCollectorContext();
    }

    public static DataCollectorContext build(ModelMap modelMap){
        DataCollectorContext context = build();
        context.setModelMap(modelMap);
        return context;
    }

    public static DataCollectorContext build(ModelMap modelMap,String page){
        DataCollectorContext context = build();
        context.setModelMap(modelMap);
        context.setPage(page);
        return context;
    }

    public static DataCollectorContext build(ModelMap modelMap,Integer siteId){
        DataCollectorContext context = build();
        context.setModelMap(modelMap);
        context.setSiteId(siteId);
        return context;
    }

    public static DataCollectorContext build(ModelMap modelMap,Integer siteId,ArticleSearchDO articleRequestDO){
        DataCollectorContext context = build();
        context.setModelMap(modelMap);
        context.setSiteId(siteId);
        context.setArticleRequestDO(articleRequestDO);
        return context;
    }

    public static DataCollectorContext build(ModelMap modelMap,ArticleSearchDO articleRequestDO){
        DataCollectorContext context = build();
        context.setModelMap(modelMap);
        context.setArticleRequestDO(articleRequestDO);
        return context;
    }

    public static DataCollectorContext build(ModelMap modelMap,ArticleSearchDO articleRequestDO,String page){
        DataCollectorContext context = build();
        context.setModelMap(modelMap);
        context.setArticleRequestDO(articleRequestDO);
        context.setPage(page);
        return context;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public ModelMap getModelMap() {
        return modelMap;
    }

    public void setModelMap(ModelMap modelMap) {
        this.modelMap = modelMap;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public ArticleSearchDO getArticleRequestDO() {
        return articleRequestDO;
    }

    public void setArticleRequestDO(ArticleSearchDO articleRequestDO) {
        this.articleRequestDO = articleRequestDO;
    }
}
