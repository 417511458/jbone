package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.SiteSettingsDO;
import cn.jbone.cms.core.dao.entity.SiteSettings;
import cn.jbone.cms.core.dao.repository.SiteSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SiteSettingsConverter {

    @Autowired
    private SiteSettingsRepository siteSettingsRepository;

    public SiteSettingsDO toDO(SiteSettings siteSettings){
        if(siteSettings == null){
            return null;
        }

        SiteSettingsDO siteSettingsDO = new SiteSettingsDO();
        siteSettingsDO.setId(siteSettings.getId());
        siteSettingsDO.setName(siteSettings.getName());
        siteSettingsDO.setSiteId(siteSettings.getSiteId());
        siteSettingsDO.setValue(siteSettings.getValue());
        siteSettingsDO.setDataType(siteSettings.getDataType());
        siteSettingsDO.setPrompt(siteSettings.getPrompt());
        return siteSettingsDO;
    }

    public List<SiteSettingsDO> toDOs(List<SiteSettings> settingsList){
        if(CollectionUtils.isEmpty(settingsList)){
            return null;
        }
        List<SiteSettingsDO> settingsDOList = new ArrayList<>();
        for (SiteSettings settings : settingsList){
            SiteSettingsDO settingsDO = toDO(settings);
            if(settingsDO != null){
                settingsDOList.add(settingsDO);
            }
        }
        return settingsDOList;
    }

    public SiteSettings toEntity(SiteSettingsDO settingsDO){
        if(settingsDO == null){
            return null;
        }
        SiteSettings settings = null;
        if(settingsDO.getId() != null && settingsDO.getId() > 0){
            settings = siteSettingsRepository.getOne(settingsDO.getId());
        }
        if(settings == null){
            settings = new SiteSettings();
        }
        settings.setName(settingsDO.getName());
        settings.setSiteId(settingsDO.getSiteId());
        settings.setValue(settingsDO.getValue());
        settings.setDataType(settingsDO.getDataType());
        settings.setPrompt(settingsDO.getPrompt());
        return settings;
    }

    public List<SiteSettings> toEntitys(List<SiteSettingsDO> settingsDOs){
        if(settingsDOs == null){
            return null;
        }

        List<SiteSettings> list = new ArrayList<>();
        for (SiteSettingsDO siteSettingsDO : settingsDOs){
            SiteSettings siteSettings = toEntity(siteSettingsDO);
            if(siteSettings != null){
                list.add(siteSettings);
            }
        }
        return list;
    }
}
