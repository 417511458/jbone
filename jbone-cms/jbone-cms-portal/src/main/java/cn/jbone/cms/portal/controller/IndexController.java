package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.portal.service.ArticleService;
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
    private ArticleService articleService;

    @RequestMapping("/")
    public String index(ModelMap modelMap, @RequestParam(value="p",required = false) Integer p){
        commonService.setCommonModuleDatas(modelMap);
        int pageNumber = (p == null) ? 1 : p;

        ArticleCommonRequestDO articleCommonRequestDO = ArticleCommonRequestDO.build(pageNumber);

        modelMap.addAttribute("pagedArticles",articleService.findArticles(articleCommonRequestDO));

        return "index";
    }
}
