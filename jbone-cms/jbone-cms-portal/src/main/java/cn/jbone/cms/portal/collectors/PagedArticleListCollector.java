package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("pagedArticleListCollector")
public class PagedArticleListCollector implements IDataCollector {

    @Autowired
    private ArticleApi articleApi;

    private String DATA_KEY = "pagedArticles";

    @Override
    public void collect(DataCollectorContext context) {
        if(context.getArticleRequestDO() == null){
            return;
        }
        context.getArticleRequestDO().setSiteId(context.getSiteId());
        context.getArticleRequestDO().getStatusList().add(StatusEnum.PUBLISH);
        Result<PagedResponseDO<ArticleResponseDO>> result = articleApi.commonRequest(context.getArticleRequestDO());
        if(result != null && result.isSuccess()){
            PagedResponseDO<ArticleResponseDO> data = result.getData();
            if(data != null){
                data.buildPagination();
            }
            context.addAttribute(DATA_KEY,data);
        }
    }
}
