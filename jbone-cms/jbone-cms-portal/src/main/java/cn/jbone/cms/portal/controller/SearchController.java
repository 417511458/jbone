package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.PagedResponseDO;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.LinkService;
import cn.jbone.cms.portal.service.TagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping("search")
    public String index(ModelMap modelMap, @RequestParam(value="keywords",required = false) String keywords,@RequestParam(value="p",required = false) Integer p){
        commonService.setCommonModuleDatas(modelMap);

        int pageNumber = (p == null) ? 1 : p;

        ArticleCommonRequestDO articleCommonRequestDO = ArticleCommonRequestDO.build(pageNumber);

        if(StringUtils.isNotBlank(keywords)){
            articleCommonRequestDO.setTitle(keywords);
        }

        modelMap.addAttribute("pagedArticles",articleService.findArticles(articleCommonRequestDO));

        modelMap.addAttribute("keywords",keywords);

        return "search";
    }
}
