package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleApi articleApi;
    @Autowired
    private CategoryService categoryService;

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
        ArticleResponseDO article = findById(id);
        if(article == null){
            return;
        }

        CategoryDO categoryDO = null;
        if(article.getCategory() != null){
            categoryDO = categoryService.findById(article.getCategory().getId());
        }
        modelMap.addAttribute("category",categoryDO);
        modelMap.addAttribute("article",article);
    }
}
