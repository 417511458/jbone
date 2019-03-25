package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.PagedResponseDO;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.LinkService;
import cn.jbone.cms.portal.service.TagService;
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
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private LinkService linkService;

    @RequestMapping("/")
    public String index(ModelMap modelMap, @RequestParam(value="p",required = false) Integer p){
        commonService.setCommonProperties(modelMap);

        int pageNumber = (p == null) ? 1 : p;

        ArticleCommonRequestDO articleCommonRequestDO = new ArticleCommonRequestDO();
        articleCommonRequestDO.setPageNumber(pageNumber);
        articleCommonRequestDO.setPageSize(10);
        articleCommonRequestDO.setSortName("addTime");
        articleCommonRequestDO.setSortOrder("desc");

        PagedResponseDO<ArticleResponseDO> pagedResponseDO = articleService.findArticles(articleCommonRequestDO);
        modelMap.addAttribute("pagedArticles",pagedResponseDO);

        modelMap.addAttribute("hotArticles",articleService.findHotArticles());
        modelMap.addAttribute("tagCloud",tagService.findTagCloud());
        modelMap.addAttribute("links",linkService.findAll());

        return "index";
    }
}
