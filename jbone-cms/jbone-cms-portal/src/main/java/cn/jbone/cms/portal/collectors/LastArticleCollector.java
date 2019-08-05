package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.dataobject.SearchConditionDO;
import cn.jbone.common.dataobject.SearchSortDO;
import cn.jbone.common.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Date;

@Repository("lastArticleCollector")
public class LastArticleCollector implements IDataCollector {

    @Autowired
    private ArticleService articleService;

    private String DATA_KEY = "lastArticle";

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void collect(DataCollectorContext context) {
        if(context.getArticle() == null){
            logger.warn("收集上一篇文章，却没找到文章。");
            return;
        }

        ArticleSearchDO articleSearchDO = ArticleSearchDO.build();
        articleSearchDO.setPageSize(1);
        articleSearchDO.setSiteId(context.getSiteId());
        articleSearchDO.setCategoryId(context.getCategory().getId());
        articleSearchDO.getStatusList().add(StatusEnum.PUBLISH);

        String conditionValue = DateUtil.formateDate(new Date(context.getArticle().getAddTime()),DateUtil.TIME_FORMAT);
        articleSearchDO.addCondition(new SearchConditionDO("addTime",SearchConditionDO.Operator.LESS_THAN,conditionValue));
        articleSearchDO.addSort(new SearchSortDO("addTime", SearchSortDO.Direction.DESC));

        PagedResponseDO<ArticleResponseDO> result = articleService.findArticles(articleSearchDO);
        if (result != null && !CollectionUtils.isEmpty(result.getDatas())){
            context.addAttribute(DATA_KEY,result.getDatas().get(0));
        }
    }
}
