package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.dataobject.config.ArticleFiledConfigDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.TagService;
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
    private ArticleService articleService;
    @Autowired
    private TagService tagService;


    @RequestMapping("tag/{tagId}")
    public String index(ModelMap modelMap, @PathVariable(value="tagId") long tagId, @RequestParam(value="p",required = false) Integer p){
        commonService.setCommonModuleDatas(modelMap);

        int pageNumber = (p == null) ? 1 : p;

        ArticleSearchDO articleSearchDO = ArticleSearchDO.build(pageNumber);
        articleSearchDO.setConfig(ArticleFiledConfigDO.buildAll().includeContent(false));

        if(tagId > 0){
            articleSearchDO.setTagIds(Arrays.asList(tagId));
        }

        modelMap.addAttribute("pagedArticles",articleService.findArticles(articleSearchDO));

        modelMap.addAttribute("tag",tagService.findById(tagId));

        return "tag";
    }
}
