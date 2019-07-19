package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.config.ArticleFiledConfigDO;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.enums.CategoryShowTypeEnum;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.portal.collectors.DataCollectorContext;
import cn.jbone.cms.portal.collectors.DataCollectorHandler;
import cn.jbone.cms.portal.service.ArticleService;
import cn.jbone.cms.portal.service.CategoryService;
import cn.jbone.cms.portal.service.CommonService;
import cn.jbone.cms.portal.service.TagService;
import cn.jbone.cms.portal.vo.SpecialTreeVo;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.errors.Jbone404Exception;
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
    private CategoryService categoryService;

    @Autowired
    private DataCollectorHandler dataCollectorHandler;

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
        CategoryDO categoryDO = categoryService.findById(categoryId);
        if(categoryDO == null){
            throw new Jbone404Exception();
        }

        int pageNumber = (p == null) ? 1 : p;

        ArticleSearchDO articleSearchDO = ArticleSearchDO.build(pageNumber);
        articleSearchDO.setConfig(ArticleFiledConfigDO.buildAll().includeContent(false));

        //专题文章
        if(categoryDO.getType() == CategoryTypeEnum.SPECIAL){
            return "redirect:/special/" + categoryId + "";
        }

        //普通分类文章
        else if(categoryDO.getType() == CategoryTypeEnum.CATEGORY){

            //列表展示，返回到列表页
            if(categoryDO.getShowType() == CategoryShowTypeEnum.LIST){
                articleSearchDO.setCategoryId(categoryId);
            }
            //第一篇文章，跳转到文章详情页
            else if(categoryDO.getShowType() == CategoryShowTypeEnum.FIRSTARTICLE){
                ArticleResponseDO articleResponseDO = articleService.getFirstArticle(categoryId);
                if(articleResponseDO == null){
                    throw new Jbone404Exception();
                }
                return "redirect:/article/" + articleResponseDO.getId();
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
        }


        dataCollectorHandler.handle(DataCollectorContext.build(modelMap,articleSearchDO,DictionaryConstant.ITEM_PAGE_NAME_CATEGORY));

        modelMap.addAttribute("category",categoryDO);

        return commonService.getTemplatePage(DictionaryConstant.ITEM_PAGE_NAME_CATEGORY);
    }

    @RequestMapping("special/{categoryId}")
    public String specialRoot(ModelMap modelMap, @PathVariable(value="categoryId") long categoryId, HttpServletRequest request){
        return special(modelMap,categoryId,0l,request);
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
        CategoryDO categoryDO = categoryService.findById(categoryId);
        if(categoryDO == null){
            throw new Jbone404Exception();
        }

        //专题文章
        if(categoryDO.getType() == CategoryTypeEnum.SPECIAL){
            List<CategoryTocDO> categoryTocDOS = categoryService.getCategoryTocTree(categoryId);
            if(!CollectionUtils.isEmpty(categoryTocDOS)){
                CategoryTocDO categoryTocDO = null;
                if(tocId != null && tocId > 0){
                    categoryTocDO = categoryService.getTocById(tocId);
                }else{
                    categoryTocDO = categoryTocDOS.get(0);
                }
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

        dataCollectorHandler.handle(DataCollectorContext.build(modelMap,DictionaryConstant.ITEM_PAGE_NAME_SPECIAL));

        return commonService.getTemplatePage(DictionaryConstant.ITEM_PAGE_NAME_SPECIAL);
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
