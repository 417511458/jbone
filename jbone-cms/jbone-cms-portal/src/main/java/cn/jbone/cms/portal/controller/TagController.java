package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.cms.common.dataobject.config.ArticleFiledConfigDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.portal.collectors.DataCollectorContext;
import cn.jbone.cms.portal.collectors.DataCollectorHandler;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.TagService;
import cn.jbone.errors.Jbone404Exception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class TagController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private TagService tagService;

    @Autowired
    private DataCollectorHandler dataCollectorHandler;


    @RequestMapping("tag/{tagId}")
    public String index(ModelMap modelMap, @PathVariable(value="tagId") long tagId, @RequestParam(value="p",required = false) Integer p){
        TagDO tagDO = tagService.findById(tagId);
        if(tagDO == null){
            throw new Jbone404Exception();
        }
        modelMap.addAttribute("tag",tagDO);



        //交给数据收集器处理
        int pageNumber = (p == null) ? 1 : p;
        ArticleSearchDO articleSearchDO = ArticleSearchDO.build(pageNumber);
        articleSearchDO.setConfig(ArticleFiledConfigDO.buildAll().includeContent(false));
        if(tagId > 0){
            articleSearchDO.setTagIds(Arrays.asList(tagId));
        }

        DataCollectorContext context = DataCollectorContext.build(modelMap,articleSearchDO, DictionaryConstant.ITEM_PAGE_NAME_TAG);
        dataCollectorHandler.handle(context);


        return commonService.getTemplatePage(DictionaryConstant.ITEM_PAGE_NAME_TAG);
    }
}
