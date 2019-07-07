package cn.jbone.cms.portal.service;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.portal.manager.SiteManager;
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
