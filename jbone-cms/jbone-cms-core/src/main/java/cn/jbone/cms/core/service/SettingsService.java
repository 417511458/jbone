package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.SettingsDO;
import cn.jbone.cms.core.converter.SettingsConverter;
import cn.jbone.cms.core.dao.entity.Settings;
import cn.jbone.cms.core.dao.repository.SettingsRepository;
import cn.jbone.common.exception.ObjectNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.http2.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SettingsService {
    @Autowired
    private SettingsRepository settingsRepository;

    @Autowired
    private SettingsConverter settingsConverter;

    public Map<String, SettingsDO> getSettingsMap(){
        Map<String, SettingsDO> settingsDOMap = new HashMap<>();
        List<SettingsDO> settingsDOList = getSettingsList();
        if(!CollectionUtils.isEmpty(settingsDOList)){
            for (SettingsDO settingsDO : settingsDOList){
                settingsDOMap.put(settingsDO.getSettingKey(),settingsDO);
            }
        }
        return settingsDOMap;
    }

    public List<SettingsDO> getSettingsList(){
        List<Settings> settingsList = settingsRepository.findAll();
        List<SettingsDO> settingsDOList = settingsConverter.toSettingsDOs(settingsList);
        return settingsDOList;
    }

    public void addOrUpdate(SettingsDO settingsDO){
        Settings settings = settingsConverter.toSettings(settingsDO);
        settingsRepository.save(settings);
    }

    public void delete(Long id){
        if(!settingsRepository.existsById(id)){
            throw  new ObjectNotFoundException("配置不存在.");
        }

        settingsRepository.deleteById(id);
    }

    public void batchDelete(String ids){
        if(StringUtils.isBlank(ids)){
            return;
        }
        String[] idArray = ids.split(",");
        if(idArray == null && ids.length() <= 0){
            return;
        }
        List<Settings> settingsList = new ArrayList<>();
        for (String id : idArray){
            if(StringUtils.isBlank(id)){
                continue;
            }
            Settings settings = new Settings();
            settings.setId(Long.parseLong(id));
            settingsList.add(settings);
        }

        settingsRepository.deleteInBatch(settingsList);
    }

    public SettingsDO get(Long id){
        return settingsConverter.toSettingsDO(settingsRepository.getOne(id));
    }
}
