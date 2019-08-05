package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.portal.cache.CachedSiteManager;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.dataobject.SearchConditionDO;
import cn.jbone.common.dataobject.SearchSortDO;
import cn.jbone.common.rpc.Result;
import cn.jbone.common.utils.DateUtil;
import cn.jbone.errors.Jbone404Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.Date;

@Service
public class ArticleService {

    @Autowired
    private ArticleApi articleApi;

    @Autowired
    private CachedSiteManager cachedSiteManager;

    public PagedResponseDO<ArticleResponseDO> findArticles(ArticleSearchDO articleRequestDO){
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


    public ArticleResponseDO findById(Long id){
        Result<ArticleResponseDO> result = articleApi.get(id);
        if(result != null && result.isSuccess()){
            return result.getData();
        }
        return null;
    }

    public void hits(Long id){
        articleApi.hits(id); //增加阅读量
    }

    public void toArticleDetail(ModelMap modelMap,ArticleResponseDO article,CategoryDO categoryDO){
        if(article == null){
            return;
        }

        hits(article.getId());

        modelMap.addAttribute("category",categoryDO);
        modelMap.addAttribute("article",article);
        modelMap.addAttribute("articlePlugins", cachedSiteManager.getCurrentPlugsByType(DictionaryConstant.ITEM_PLUGIN_TYPE_ARTICLE));
    }


    //第一篇文章
    public ArticleResponseDO getFirstArticle(Long categoryId){
        ArticleSearchDO articleSearchDO = ArticleSearchDO.build();
        articleSearchDO.setPageSize(1);
        articleSearchDO.setCategoryId(categoryId);
        articleSearchDO.setSiteId(cachedSiteManager.getCurrentSiteId());
        articleSearchDO.addSort(new SearchSortDO("orders",SearchSortDO.Direction.ASC));

        PagedResponseDO<ArticleResponseDO> result = findArticles(articleSearchDO);
        if (result != null && !CollectionUtils.isEmpty(result.getDatas())){
            return  result.getDatas().get(0);
        }
        return null;
    }

}
