package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.config.ArticleFiledConfigDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.portal.collectors.DataCollectorContext;
import cn.jbone.cms.portal.collectors.DataCollectorHandler;
import cn.jbone.cms.portal.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private DataCollectorHandler dataHandler;

    @RequestMapping("/")
    public String index(ModelMap modelMap, @RequestParam(value="p",required = false) Integer p){
        int pageNumber = (p == null) ? 1 : p;
        ArticleSearchDO articleSearchDO = ArticleSearchDO.build(pageNumber);
        articleSearchDO.setConfig(ArticleFiledConfigDO.buildAll().includeContent(false));

        //交给数据收集器处理
        dataHandler.handle(DataCollectorContext.build(modelMap,articleSearchDO, DictionaryConstant.ITEM_PAGE_NAME_INDEX));

        return commonService.getTemplatePage(DictionaryConstant.ITEM_PAGE_NAME_INDEX);
    }
}
