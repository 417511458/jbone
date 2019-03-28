package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import cn.jbone.common.utils.DateUtil;
import cn.jbone.common.utils.SpecificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleApi articleApi;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;

    public PagedResponseDO<ArticleResponseDO> findArticles(ArticleCommonRequestDO articleRequestDO){
        Result<PagedResponseDO<ArticleResponseDO>> result = articleApi.commonRequest(articleRequestDO);
        if(result != null && result.isSuccess()){
            PagedResponseDO<ArticleResponseDO> data = result.getData();
            if(data != null){
                data.buildPagination();
            }
            return data;
        }
        return null;
    }

    public List<ArticleResponseDO> findHotArticles(){
        ArticleCommonRequestDO articleCommonRequestDO = ArticleCommonRequestDO.build();
        articleCommonRequestDO.setSortOrder("desc");
        articleCommonRequestDO.setSortName("hits");

        Result<PagedResponseDO<ArticleResponseDO>> result = articleApi.commonRequest(articleCommonRequestDO);
        if(result != null && result.isSuccess()){
            PagedResponseDO<ArticleResponseDO> data = result.getData();
            if(data != null){
                return data.getDatas();
            }
        }
        return null;
    }

    public ArticleResponseDO findById(Long id){
        Result<ArticleResponseDO> result = articleApi.get(id);
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }

    public void toArticleDetail(ModelMap modelMap,Long id){
        articleApi.hits(id); //增加阅读量
        ArticleResponseDO article = findById(id);
        if(article == null){
            return;
        }

        CategoryDO categoryDO = null;
        if(article.getCategory() != null){
            categoryDO = categoryService.findById(article.getCategory().getId());
        }

        toArticleDetail(modelMap,article,categoryDO);
    }

    public void toArticleDetail(ModelMap modelMap,ArticleResponseDO article,CategoryDO categoryDO){
        if(article == null){
            return;
        }

        modelMap.addAttribute("category",categoryDO);
        modelMap.addAttribute("article",article);
        modelMap.addAttribute("lastArticle",getLastOrNextArticle(article,SpecificationUtils.GREATER_THAN));
        modelMap.addAttribute("nextArticle",getLastOrNextArticle(article,SpecificationUtils.LESS_THAN));
        modelMap.addAttribute("comments",commentService.getByArticleId(article.getId()));
    }

    //上一篇文章
    private ArticleResponseDO getLastOrNextArticle(ArticleResponseDO article,String key){
        ArticleCommonRequestDO articleCommonRequestDO = ArticleCommonRequestDO.build();
        articleCommonRequestDO.setPageSize(1);
        if(article.getCategory() != null){
            articleCommonRequestDO.setCategoryId(article.getCategory().getId());
        }
        String conditionKey = SpecificationUtils.SEARCH_PREFIX  + "addTime_" + key;
        String conditionValue = DateUtil.formateDate(new Date(article.getAddTime()),DateUtil.TIME_FORMAT);
        articleCommonRequestDO.getCondition().put(conditionKey, conditionValue);

        PagedResponseDO<ArticleResponseDO> result = findArticles(articleCommonRequestDO);
        if (result != null && !CollectionUtils.isEmpty(result.getDatas())){
            return  result.getDatas().get(0);
        }
        return null;
    }

    //第一篇文章
    public ArticleResponseDO getFirstArticle(Long categoryId){
        ArticleCommonRequestDO articleCommonRequestDO = ArticleCommonRequestDO.build();
        articleCommonRequestDO.setPageSize(1);
        articleCommonRequestDO.setCategoryId(categoryId);
        articleCommonRequestDO.setSortName("orders");
        articleCommonRequestDO.setSortOrder("asc");

        PagedResponseDO<ArticleResponseDO> result = findArticles(articleCommonRequestDO);
        if (result != null && !CollectionUtils.isEmpty(result.getDatas())){
            return  result.getDatas().get(0);
        }
        return null;
    }

}
