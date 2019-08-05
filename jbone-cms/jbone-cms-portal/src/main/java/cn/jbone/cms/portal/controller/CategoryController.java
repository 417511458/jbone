package cn.jbone.cms.portal.controller;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.constant.GlobalConstant;
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
import cn.jbone.common.exception.JboneException;
import cn.jbone.errors.Jbone404Exception;
import com.alibaba.fastjson.JSON;
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
     * @param code 栏目编码
     * @param p
     * @param request
     * @return
     */
    @RequestMapping("category/{code}")
    public String index(ModelMap modelMap, @PathVariable(value="code") String code, @RequestParam(value="p",required = false) Integer p, HttpServletRequest request){
        CategoryDO categoryDO = categoryService.findByCode(code);
        if(categoryDO == null){
            throw new Jbone404Exception();
        }

        int pageNumber = (p == null) ? 1 : p;

        //专题文章
        if(categoryDO.getType() == CategoryTypeEnum.SPECIAL){
            return toSpecial(modelMap,categoryDO,0l,request);
        }

        //普通分类文章
        else if(categoryDO.getType() == CategoryTypeEnum.CATEGORY){
            return toCategory(modelMap,categoryDO,request,pageNumber);
        }

        //标签虚拟分类
        else if(categoryDO.getType() == CategoryTypeEnum.TAG){
            return toTag(modelMap,categoryDO,request,pageNumber);
        }

        //默认跳转到普通分类
        return toCategory(modelMap,categoryDO,request,pageNumber);

    }

    /**
     * 处理标签聚合栏目
     * @param modelMap
     * @param categoryDO
     * @param request
     * @param pageNumber
     * @return
     */
    public String toTag(ModelMap modelMap, CategoryDO categoryDO, HttpServletRequest request,int pageNumber){
        ArticleSearchDO articleSearchDO = ArticleSearchDO.build(pageNumber);
        articleSearchDO.setConfig(ArticleFiledConfigDO.buildAll().includeContent(false));
        if(!CollectionUtils.isEmpty(categoryDO.getTags())){
            List<Long> tagIds = new ArrayList<>();
            for (TagDO tagDO : categoryDO.getTags()){
                tagIds.add(tagDO.getId());
            }
            articleSearchDO.setTagIds(tagIds);
        }
        dataCollectorHandler.handle(DataCollectorContext.build(modelMap,articleSearchDO,DictionaryConstant.ITEM_PAGE_NAME_CATEGORY));

        modelMap.addAttribute("category",categoryDO);

        return commonService.getTemplatePage(DictionaryConstant.ITEM_PAGE_NAME_CATEGORY);
    }

    /**
     * 处理普通栏目
     * @param modelMap
     * @param categoryDO
     * @param request
     * @param pageNumber
     * @return
     */
    public String toCategory(ModelMap modelMap, CategoryDO categoryDO, HttpServletRequest request,int pageNumber){

        ArticleSearchDO articleSearchDO = ArticleSearchDO.build(pageNumber);
        articleSearchDO.setConfig(ArticleFiledConfigDO.buildAll().includeContent(false));
        //列表展示，返回到列表页
        if(categoryDO.getShowType() == CategoryShowTypeEnum.LIST){
            articleSearchDO.setCategoryId(categoryDO.getId());
        }
        //第一篇文章，跳转到文章详情页
        else if(categoryDO.getShowType() == CategoryShowTypeEnum.FIRSTARTICLE){
            ArticleResponseDO articleResponseDO = articleService.getFirstArticle(categoryDO.getId());
            if(articleResponseDO == null){
                throw new Jbone404Exception();
            }
            return "forward:/article/" + articleResponseDO.getId();
        }

        dataCollectorHandler.handle(DataCollectorContext.build(modelMap,articleSearchDO,DictionaryConstant.ITEM_PAGE_NAME_CATEGORY));

        modelMap.addAttribute("category",categoryDO);

        return commonService.getTemplatePage(DictionaryConstant.ITEM_PAGE_NAME_CATEGORY);
    }

    /**
     * 处理专题栏目
     * @param modelMap
     * @param categoryDO
     * @param tocId
     * @param request
     * @return
     */
    public String toSpecial(ModelMap modelMap, CategoryDO categoryDO, Long tocId, HttpServletRequest request){
        List<CategoryTocDO> categoryTocDOS = categoryService.getCategoryTocTree(categoryDO.getId());
        if(!CollectionUtils.isEmpty(categoryTocDOS)){
            CategoryTocDO categoryTocDO = null;
            if(tocId != null && tocId > 0){
                categoryTocDO = categoryService.getTocById(tocId);
            }else{
                categoryTocDO = categoryTocDOS.get(0);
            }
            List<SpecialTreeVo> specialTreeVos =  getTreeVo(categoryTocDOS,request.getContextPath(),categoryTocDO,categoryDO);
            modelMap.addAttribute("specialTree", specialTreeVos);
            modelMap.addAttribute("categoryToc",categoryTocDO);
            if(categoryTocDO.getArticle() != null){
                articleService.hits(categoryTocDO.getArticle().getId());
                ArticleResponseDO articleResponseDO = articleService.findById(categoryTocDO.getArticle().getId());
                modelMap.addAttribute("article",articleResponseDO);
            }
        }
        modelMap.addAttribute("category",categoryDO);

        dataCollectorHandler.handle(DataCollectorContext.build(modelMap,DictionaryConstant.ITEM_PAGE_NAME_SPECIAL));

        return commonService.getTemplatePage(DictionaryConstant.ITEM_PAGE_NAME_SPECIAL);
    }


    /**
     * 专题文章
     * @param modelMap
     * @param tocId
     * @param request
     * @return
     */
    @RequestMapping("category/{code}/{tocId}")
    public String special(ModelMap modelMap, @PathVariable(value="code") String code, @PathVariable(value="tocId") Long tocId, HttpServletRequest request){
        CategoryDO categoryDO = categoryService.findByCode(code);
        if(categoryDO == null){
            throw new Jbone404Exception();
        }

        //专题文章
        if(categoryDO.getType() == CategoryTypeEnum.SPECIAL){
            return toSpecial(modelMap,categoryDO,tocId,request);
        }else{
            return index(modelMap,code,0,request);
        }

    }

    private List<SpecialTreeVo> getTreeVo(List<CategoryTocDO> categoryTocDOS,String contextPath,CategoryTocDO currentToc,CategoryDO categoryDO){
        if(CollectionUtils.isEmpty(categoryTocDOS)){
            return null;
        }
        List<SpecialTreeVo> specialTreeVos = new ArrayList<>();
        for (CategoryTocDO categoryTocDO:categoryTocDOS) {
            SpecialTreeVo specialTreeVo = new SpecialTreeVo();
            specialTreeVo.setNodes(getTreeVo(categoryTocDO.getChildren(),contextPath,currentToc,categoryDO));
            if(categoryTocDO.getId() == currentToc.getId()){
                specialTreeVo.getState().setSelected(true);
            }
            specialTreeVo.setText(categoryTocDO.getTitle());
            if(StringUtils.isBlank(categoryTocDO.getType()) || GlobalConstant.CATEGORY_TOC_TYPE_INNER.equalsIgnoreCase(categoryTocDO.getType())){
                specialTreeVo.setHref(contextPath + "/category/" + categoryDO.getCode() + "/" + categoryTocDO.getId());
            }else{
                specialTreeVo.setHref(categoryTocDO.getUrl());
            }
            specialTreeVos.add(specialTreeVo);

        }
        return specialTreeVos;
    }
}
