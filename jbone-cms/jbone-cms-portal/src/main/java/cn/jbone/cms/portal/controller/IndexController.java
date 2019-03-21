package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.PagedResponseDO;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        commonService.setCommonProperties(modelMap);


        ArticleCommonRequestDO articleCommonRequestDO = new ArticleCommonRequestDO();
        articleCommonRequestDO.setPageNumber(1);
        articleCommonRequestDO.setPageSize(10);
        articleCommonRequestDO.setSortName("addTime");
        articleCommonRequestDO.setSortOrder("desc");

        PagedResponseDO<ArticleResponseDO> pagedResponseDO = articleService.findArticles(articleCommonRequestDO);
        modelMap.addAttribute("pagedArticles",pagedResponseDO);

        return "index";
    }
}
