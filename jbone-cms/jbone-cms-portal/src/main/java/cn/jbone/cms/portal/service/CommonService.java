package cn.jbone.cms.portal.service;

import cn.jbone.cms.api.CategoryApi;
import cn.jbone.cms.api.SettingsApi;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.search.CategorySearchDO;
import cn.jbone.cms.common.dataobject.SettingsDO;
import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommonService {

    @Autowired
    private SettingsApi settingsApi;

    @Autowired
    private CategoryApi categoryApi;

    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private LinkService linkService;

    public void setCommonProperties(ModelMap modelMap){
        setSettings(modelMap);
        setMenus(modelMap);
    }

    public void setCommonModuleDatas(ModelMap modelMap){
        modelMap.addAttribute("hotArticles",articleService.findHotArticles());
        modelMap.addAttribute("tagCloud",tagService.findTagCloud());
        modelMap.addAttribute("links",linkService.findAll());
    }


    private void setMenus(ModelMap modelMap){
        CategorySearchDO categorySearchDO = new CategorySearchDO();
        categorySearchDO.setInMenu(BooleanEnum.TRUE);
        categorySearchDO.setStatus(StatusEnum.PUBLISH);
        Result<List<CategoryDO>> result = categoryApi.requestCategorysTree(categorySearchDO);
        if(result.isSuccess()){
            modelMap.addAttribute("menus",result.getData());
        }
    }

    private void setSettings(ModelMap modelMap){
        Result<Map<String, SettingsDO>> settingMap =  settingsApi.getMap();
        if(settingMap.isSuccess()){
            if(!CollectionUtils.isEmpty(settingMap.getData())){
                Map<String,String> settings = new HashMap<>();
                for (Map.Entry<String,SettingsDO> entry : settingMap.getData().entrySet()) {
                    settings.put(entry.getKey(),entry.getValue().getSettingValue());
                }
                modelMap.addAttribute("settings",settings);
            }
        }
    }

}
