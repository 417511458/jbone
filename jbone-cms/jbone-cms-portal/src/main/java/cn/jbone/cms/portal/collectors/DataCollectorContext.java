package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import lombok.Data;
import org.springframework.ui.ModelMap;

import java.io.Serializable;

@Data
public class DataCollectorContext implements Serializable {
    private ModelMap modelMap;
    private Integer siteId;
    private ArticleSearchDO articleRequestDO;
    private String page;
    private ArticleResponseDO article;
    private CategoryDO category;

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

}
