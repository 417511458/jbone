package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.cms.portal.cache.CachedSiteManager;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.vo.SinglePageCategoryVo;
import cn.jbone.common.dataobject.PagedResponseDO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 单页模版搜集器
 */
@Repository("singlePageIndexCollector")
public class SinglePageIndexCollector implements IDataCollector{

    @Autowired
    private CachedSiteManager siteManager;

    @Autowired
    private ArticleService articleService;

    @Override
    public void collect(DataCollectorContext context) {
        List<CategoryDO> categoryDOS = siteManager.getCurrentMenus();
        if(CollectionUtils.isEmpty(categoryDOS)){
            return;
        }

        List<SinglePageCategoryVo> list = new ArrayList<>();
        for (CategoryDO categoryDO : categoryDOS){
            if(StringUtils.isNotBlank(categoryDO.getUrl())){
                continue;
            }
            SinglePageCategoryVo singlePageCategoryVo = new SinglePageCategoryVo();
            singlePageCategoryVo.setId(categoryDO.getId());
            singlePageCategoryVo.setTitle(categoryDO.getTitle());

            ArticleSearchDO articleSearchDO = ArticleSearchDO.build();
            articleSearchDO.setCategoryId(categoryDO.getId());
            articleSearchDO.getConfig().includeContent(true);
            articleSearchDO.getStatusList().add(StatusEnum.PUBLISH);
            articleSearchDO.setSiteId(context.getSiteId());
            PagedResponseDO<ArticleResponseDO> pagedResponseDO = articleService.findArticles(articleSearchDO);
            if(pagedResponseDO != null){
                singlePageCategoryVo.setArticleList(pagedResponseDO.getDatas());
            }


            list.add(singlePageCategoryVo);
        }

        context.addAttribute("categoryList",list);

    }
}
