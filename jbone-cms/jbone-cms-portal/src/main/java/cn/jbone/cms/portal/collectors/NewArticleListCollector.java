package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.dataobject.SearchSortDO;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 最新文章数据收集器
 */
@Repository("newArticleListCollector")
public class NewArticleListCollector implements IDataCollector {

    @Autowired
    private ArticleApi articleApi;

    private String DATA_KEY = "newArticles";

    @Override
    public void collect(DataCollectorContext context) {
        ArticleSearchDO articleSearchDO = ArticleSearchDO.build();
        articleSearchDO.clearSort();
        articleSearchDO.addSort(new SearchSortDO("addTime",SearchSortDO.Direction.DESC));
        articleSearchDO.addSort(new SearchSortDO("hits",SearchSortDO.Direction.DESC));
        articleSearchDO.setSiteId(context.getSiteId());
        articleSearchDO.getStatusList().add(StatusEnum.PUBLISH);

        List<ArticleResponseDO> articleResponseDOList = null;
        Result<PagedResponseDO<ArticleResponseDO>> result = articleApi.commonRequest(articleSearchDO);
        if(result != null && result.isSuccess()){
            PagedResponseDO<ArticleResponseDO> data = result.getData();
            if(data != null){
                articleResponseDOList = data.getDatas();
            }
        }
        context.addAttribute(DATA_KEY,articleResponseDOList);
    }
}
