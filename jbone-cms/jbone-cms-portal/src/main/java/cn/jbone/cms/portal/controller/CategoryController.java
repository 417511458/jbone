package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CategoryService;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.TagService;
import cn.jbone.errors.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CommonService commonService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CategoryService categoryService;

    public static String PAGE_CATEGORY = "category";
    public static String PAGE_SPECIAL = "special";

    @RequestMapping("category/{categoryId}")
    public String index(ModelMap modelMap, @PathVariable(value="categoryId") long categoryId, @RequestParam(value="p",required = false) Integer p){
        commonService.setCommonProperties(modelMap);
        commonService.setCommonModuleDatas(modelMap);

        CategoryDO categoryDO = categoryService.findById(categoryId);
        if(categoryDO == null){
            return PageCode.PAGE_404;
        }

        PagedResponseDO<ArticleResponseDO> pagedArticles = null;
        String pageName = PAGE_CATEGORY;

        int pageNumber = (p == null) ? 1 : p;

        ArticleCommonRequestDO articleCommonRequestDO = ArticleCommonRequestDO.build(pageNumber);

        //专题文章
        if(categoryDO.getType() == CategoryTypeEnum.SPECIAL){
            pageName = PAGE_SPECIAL;
        }
        //普通分类文章
        else if(categoryDO.getType() == CategoryTypeEnum.CATEGORY){


        }
        //标签虚拟分类
        else if(categoryDO.getType() == CategoryTypeEnum.TAG){
            if(!CollectionUtils.isEmpty(categoryDO.getTags())){
                List<Long> tagIds = new ArrayList<>();
                for (TagDO tagDO : categoryDO.getTags()){
                    tagIds.add(tagDO.getId());
                }
                articleCommonRequestDO.setTagIds(tagIds);
            }

            pagedArticles = articleService.findArticles(articleCommonRequestDO);
        }


        modelMap.addAttribute("pagedArticles",pagedArticles);

        modelMap.addAttribute("category",categoryDO);

        return pageName;
    }
}
