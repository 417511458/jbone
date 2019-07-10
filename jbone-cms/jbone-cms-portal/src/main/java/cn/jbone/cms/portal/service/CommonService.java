package cn.jbone.cms.portal.service;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.portal.manager.SiteManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;


@Service
public class CommonService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private SiteManager siteManager;

    public void setCommonProperties(ModelMap modelMap){
        setSettings(modelMap);
        setMenus(modelMap);
        setGlobalPlugins(modelMap);
    }

    public void setCommonModuleDatas(ModelMap modelMap){
        modelMap.addAttribute("hotArticles",articleService.findHotArticles());
        modelMap.addAttribute("tagCloud",tagService.findTagCloud());
        modelMap.addAttribute("links",siteManager.getCurrentLinks());
    }

    public String getTemplatePage(String page){
        SiteDO siteDO = siteManager.getCurrentSite();
        TemplateDO templateDO = siteDO.getTemplate();
        if(templateDO != null && !StringUtils.isBlank(templateDO.getCode())){
            return templateDO.getCode() + "/" + page;
        }
        return page;
    }


    private void setMenus(ModelMap modelMap){
        modelMap.addAttribute("menus",siteManager.getCurrentMenus());
    }

    private void setSettings(ModelMap modelMap){
        modelMap.addAttribute("settings",siteManager.getCurrentSiteSettings());
    }

    private void setGlobalPlugins(ModelMap modelMap){
        modelMap.addAttribute("globalPlugins",siteManager.getCurrentPlugsByType(DictionaryConstant.ITEM_PLUGIN_TYPE_GLOBAL));
    }

    public void setAriclePlugins(ModelMap modelMap){
        modelMap.addAttribute("articlePlugins",siteManager.getCurrentPlugsByType(DictionaryConstant.ITEM_PLUGIN_TYPE_ARTICLE));
    }
}
