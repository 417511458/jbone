package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.SettingsDO;
import cn.jbone.cms.core.dao.entity.Settings;
import cn.jbone.cms.core.dao.repository.SettingsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SettingsConverter {

    @Autowired
    private SettingsRepository settingsRepository;

    public SettingsDO toSettingsDO(Settings settings){
        if(settings == null){
            return null;
        }

        SettingsDO settingsDO = new SettingsDO();
        BeanUtils.copyProperties(settings,settingsDO);
        return settingsDO;
    }

    public List<SettingsDO> toSettingsDOs(List<Settings> settingsList){
        if(CollectionUtils.isEmpty(settingsList)){
            return null;
        }
        List<SettingsDO> settingsDOList = new ArrayList<>();
        for (Settings settings : settingsList){
            SettingsDO settingsDO = toSettingsDO(settings);
            if(settingsDO != null){
                settingsDOList.add(settingsDO);
            }
        }
        return settingsDOList;
    }

    public Settings toSettings(SettingsDO settingsDO){
        if(settingsDO == null){
            return null;
        }
        Settings settings = null;
        if(settingsDO.getId() != null && settingsDO.getId() > 0){
            settings = settingsRepository.getOne(settingsDO.getId());
        }
        if(settings == null){
            settings = new Settings();
        }
        settings.setDescription(settingsDO.getDescription());
        settings.setSettingKey(settingsDO.getSettingKey());
        settings.setSettingValue(settingsDO.getSettingValue());
        settings.setCreator(settingsDO.getCreator());
        return settings;
    }
}
