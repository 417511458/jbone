package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleApi articleApi;

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
        ArticleCommonRequestDO articleRequestDO = new ArticleCommonRequestDO();
        articleRequestDO.setSortOrder("desc");
        articleRequestDO.setSortName("hits");
        articleRequestDO.setPageSize(10);
        articleRequestDO.setPageNumber(1);

        Result<PagedResponseDO<ArticleResponseDO>> result = articleApi.commonRequest(articleRequestDO);
        if(result != null && result.isSuccess()){
            PagedResponseDO<ArticleResponseDO> data = result.getData();
            if(data != null){
                return data.getDatas();
            }
        }
        return null;
    }
}
