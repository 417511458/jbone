package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.dataobject.SearchConditionDO;
import cn.jbone.common.dataobject.SearchSortDO;
import cn.jbone.common.rpc.Result;
import cn.jbone.common.utils.DateUtil;
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

    public List<ArticleResponseDO> findHotArticles(){
        ArticleSearchDO articleSearchDO = ArticleSearchDO.build();
        articleSearchDO.clearSort();
        articleSearchDO.addSort(new SearchSortDO("hits",SearchSortDO.Direction.DESC));
        articleSearchDO.addSort(new SearchSortDO("addTime",SearchSortDO.Direction.DESC));

        Result<PagedResponseDO<ArticleResponseDO>> result = articleApi.commonRequest(articleSearchDO);
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
        hits(id);
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

    public void hits(Long id){
        articleApi.hits(id); //增加阅读量
    }

    public void toArticleDetail(ModelMap modelMap,ArticleResponseDO article,CategoryDO categoryDO){
        if(article == null){
            return;
        }

        modelMap.addAttribute("category",categoryDO);
        modelMap.addAttribute("article",article);
        modelMap.addAttribute("lastArticle",getLastOrNextArticle(article,SearchConditionDO.Operator.GREATER_THAN));
        modelMap.addAttribute("nextArticle",getLastOrNextArticle(article,SearchConditionDO.Operator.LESS_THAN));
        modelMap.addAttribute("comments",commentService.getByArticleId(article.getId()));
    }

    //上一篇文章
    private ArticleResponseDO getLastOrNextArticle(ArticleResponseDO article, SearchConditionDO.Operator operator){
        ArticleSearchDO articleSearchDO = ArticleSearchDO.build();
        articleSearchDO.setPageSize(1);
        if(article.getCategory() != null){
            articleSearchDO.setCategoryId(article.getCategory().getId());
        }
        String conditionValue = DateUtil.formateDate(new Date(article.getAddTime()),DateUtil.TIME_FORMAT);
        articleSearchDO.addCondition(new SearchConditionDO("addTime",operator,conditionValue));

        PagedResponseDO<ArticleResponseDO> result = findArticles(articleSearchDO);
        if (result != null && !CollectionUtils.isEmpty(result.getDatas())){
            return  result.getDatas().get(0);
        }
        return null;
    }

    //第一篇文章
    public ArticleResponseDO getFirstArticle(Long categoryId){
        ArticleSearchDO articleSearchDO = ArticleSearchDO.build();
        articleSearchDO.setPageSize(1);
        articleSearchDO.setCategoryId(categoryId);
        articleSearchDO.addSort(new SearchSortDO("orders",SearchSortDO.Direction.ASC));

        PagedResponseDO<ArticleResponseDO> result = findArticles(articleSearchDO);
        if (result != null && !CollectionUtils.isEmpty(result.getDatas())){
            return  result.getDatas().get(0);
        }
        return null;
    }

}
