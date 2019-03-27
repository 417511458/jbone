package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.dataobject.ArticleCommonRequestDO;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
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

        ArticleCommonRequestDO articleCommonRequestDO = ArticleCommonRequestDO.build(pageNumber);

        if(tagId > 0){
            articleCommonRequestDO.setTagIds(Arrays.asList(tagId));
        }

        modelMap.addAttribute("pagedArticles",articleService.findArticles(articleCommonRequestDO));

        modelMap.addAttribute("tag",tagService.findById(tagId));

        return "tag";
    }
}
