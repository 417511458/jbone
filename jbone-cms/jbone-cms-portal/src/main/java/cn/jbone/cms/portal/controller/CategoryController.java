package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.config.ArticleFiledConfigDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.enums.CategoryShowTypeEnum;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CategoryService;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.TagService;
import cn.jbone.cms.portal.vo.SpecialTreeVo;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.errors.PageCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    public static String PAGE_ARTICLE = "article";
    public static String PAGE_SPECIAL = "special";

    /**
     * 栏目统一入口
     * @param modelMap
     * @param categoryId
     * @param p
     * @param request
     * @return
     */
    @RequestMapping("category/{categoryId}")
    public String index(ModelMap modelMap, @PathVariable(value="categoryId") long categoryId, @RequestParam(value="p",required = false) Integer p, HttpServletRequest request){
        commonService.setCommonModuleDatas(modelMap);

        CategoryDO categoryDO = categoryService.findById(categoryId);
        if(categoryDO == null){
            return PageCode.PAGE_404;
        }

        PagedResponseDO<ArticleResponseDO> pagedArticles = null;
        String pageName = PAGE_CATEGORY;

        int pageNumber = (p == null) ? 1 : p;

        ArticleSearchDO articleSearchDO = ArticleSearchDO.build(pageNumber);
        articleSearchDO.setConfig(ArticleFiledConfigDO.buildAll().includeContent(false));

        //专题文章
        if(categoryDO.getType() == CategoryTypeEnum.SPECIAL){
            pageName = PAGE_SPECIAL;
            List<CategoryTocDO> categoryTocDOS = categoryService.getCategoryTocTree(categoryId);
            if(!CollectionUtils.isEmpty(categoryTocDOS) && categoryTocDOS.get(0) != null){
                List<SpecialTreeVo> specialTreeVos =  getTreeVo(categoryTocDOS,request.getContextPath(),categoryTocDOS.get(0),categoryId);
                modelMap.addAttribute("specialTree", specialTreeVos);
                modelMap.addAttribute("categoryToc",categoryTocDOS.get(0));
                if(categoryTocDOS.get(0).getArticle() != null){
                    ArticleResponseDO articleResponseDO = articleService.findById(categoryTocDOS.get(0).getArticle().getId());
                    modelMap.addAttribute("article",articleResponseDO);
                }
            }
        }

        //普通分类文章
        else if(categoryDO.getType() == CategoryTypeEnum.CATEGORY){

            //列表展示，返回到列表页
            if(categoryDO.getShowType() == CategoryShowTypeEnum.LIST){
                pageName = PAGE_CATEGORY;
                articleSearchDO.setCategoryId(categoryId);
                pagedArticles = articleService.findArticles(articleSearchDO);
            }
            //第一篇文章，跳转到文章详情页
            else if(categoryDO.getShowType() == CategoryShowTypeEnum.FIRSTARTICLE){
                ArticleResponseDO articleResponseDO = articleService.getFirstArticle(categoryId);
                if(articleResponseDO == null){
                    return PageCode.PAGE_404;
                }
                articleService.toArticleDetail(modelMap,articleResponseDO,categoryDO);
                return PAGE_ARTICLE;
            }

        }
        //标签虚拟分类
        else if(categoryDO.getType() == CategoryTypeEnum.TAG){
            if(!CollectionUtils.isEmpty(categoryDO.getTags())){
                List<Long> tagIds = new ArrayList<>();
                for (TagDO tagDO : categoryDO.getTags()){
                    tagIds.add(tagDO.getId());
                }
                articleSearchDO.setTagIds(tagIds);
            }

            pagedArticles = articleService.findArticles(articleSearchDO);
        }


        modelMap.addAttribute("pagedArticles",pagedArticles);

        modelMap.addAttribute("category",categoryDO);

        return pageName;
    }

    /**
     * 专题文章
     * @param modelMap
     * @param categoryId
     * @param tocId
     * @param request
     * @return
     */
    @RequestMapping("special/{categoryId}/{tocId}")
    public String special(ModelMap modelMap, @PathVariable(value="categoryId") long categoryId, @PathVariable(value="tocId") Long tocId, HttpServletRequest request){
        commonService.setCommonModuleDatas(modelMap);

        CategoryDO categoryDO = categoryService.findById(categoryId);
        if(categoryDO == null){
            return PageCode.PAGE_404;
        }

        CategoryTocDO categoryTocDO = categoryService.getTocById(tocId);
        if(categoryTocDO == null){
            return PageCode.PAGE_404;
        }

        //专题文章
        if(categoryDO.getType() == CategoryTypeEnum.SPECIAL){
            List<CategoryTocDO> categoryTocDOS = categoryService.getCategoryTocTree(categoryId);
            if(!CollectionUtils.isEmpty(categoryTocDOS)){
                List<SpecialTreeVo> specialTreeVos =  getTreeVo(categoryTocDOS,request.getContextPath(),categoryTocDO,categoryId);
                modelMap.addAttribute("specialTree", specialTreeVos);
                modelMap.addAttribute("categoryToc",categoryTocDO);
                if(categoryTocDO.getArticle() != null){
                    articleService.hits(categoryTocDO.getArticle().getId());
                    ArticleResponseDO articleResponseDO = articleService.findById(categoryTocDO.getArticle().getId());
                    modelMap.addAttribute("article",articleResponseDO);
                }
            }
        }else{
            return index(modelMap,categoryId,0,request);
        }


        modelMap.addAttribute("category",categoryDO);

        return PAGE_SPECIAL;
    }

    private List<SpecialTreeVo> getTreeVo(List<CategoryTocDO> categoryTocDOS,String contextPath,CategoryTocDO currentToc,Long categoryId){
        if(CollectionUtils.isEmpty(categoryTocDOS)){
            return null;
        }
        List<SpecialTreeVo> specialTreeVos = new ArrayList<>();
        for (CategoryTocDO categoryTocDO:categoryTocDOS) {
            SpecialTreeVo specialTreeVo = new SpecialTreeVo();
            specialTreeVo.setNodes(getTreeVo(categoryTocDO.getChildren(),contextPath,currentToc,categoryId));
            if(categoryTocDO.getId() == currentToc.getId()){
                specialTreeVo.getState().setSelected(true);
            }
            specialTreeVo.setText(categoryTocDO.getTitle());
            if(StringUtils.isNotBlank(categoryTocDO.getUrl())){
                specialTreeVo.setHref(categoryTocDO.getUrl());
            }else{
                specialTreeVo.setHref(contextPath + "/special/" + categoryId + "/" + categoryTocDO.getId());
            }
            specialTreeVos.add(specialTreeVo);

        }
        return specialTreeVos;
    }
}
