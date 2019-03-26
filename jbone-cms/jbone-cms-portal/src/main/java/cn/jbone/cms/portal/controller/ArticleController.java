package cn.jbone.cms.portal.controller;

import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CategoryService;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ArticleController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping("article/{articleId}")
    public String index(ModelMap modelMap, @PathVariable(value="articleId") long articleId){
        commonService.setCommonProperties(modelMap);
        commonService.setCommonModuleDatas(modelMap);
        articleService.toArticleDetail(modelMap,articleId);
        return "article";
    }
}
