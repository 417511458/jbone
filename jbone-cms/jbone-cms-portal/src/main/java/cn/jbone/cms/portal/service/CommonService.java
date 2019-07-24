package cn.jbone.cms.portal.service;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.constant.GlobalConstant;
import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.portal.cache.CachedSiteManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;


@Service
public class CommonService {

    @Autowired
    private CachedSiteManager cachedSiteManager;

    public void setCommonProperties(ModelMap modelMap){
        setSettings(modelMap);
        setMenus(modelMap);
        setGlobalPlugins(modelMap);
    }

    public String getTemplatePage(String page){
        SiteDO siteDO = cachedSiteManager.getCurrentSite();
        TemplateDO templateDO = siteDO.getTemplate();
        if(templateDO != null && !StringUtils.isBlank(templateDO.getCode())){
            return templateDO.getCode() + "/" + page;
        }
        return GlobalConstant.DEFAULT_TEMPLATE_CODE + "/" + page;
    }


    private void setMenus(ModelMap modelMap){
        modelMap.addAttribute("menus", cachedSiteManager.getCurrentMenus());
    }

    private void setSettings(ModelMap modelMap){
        modelMap.addAttribute("settings", cachedSiteManager.getCurrentSiteSettings());
    }

    private void setGlobalPlugins(ModelMap modelMap){
        modelMap.addAttribute("globalPlugins", cachedSiteManager.getCurrentPlugsByType(DictionaryConstant.ITEM_PLUGIN_TYPE_GLOBAL));
    }
}
