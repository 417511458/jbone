package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.BatchSaveSiteSettingDO;
import cn.jbone.cms.common.dataobject.SiteSettingsDO;
import cn.jbone.cms.core.converter.SiteSettingsConverter;
import cn.jbone.cms.core.dao.entity.Site;
import cn.jbone.cms.core.dao.entity.SiteSettings;
import cn.jbone.cms.core.dao.repository.SiteRepository;
import cn.jbone.cms.core.dao.repository.SiteSettingsRepository;
import cn.jbone.cms.core.validator.ContentValidator;
import cn.jbone.common.exception.JboneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SiteSettingsService {

    @Autowired
    private SiteSettingsRepository siteSettingsRepository;
    @Autowired
    private SiteSettingsConverter siteSettingsConverter;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private ContentValidator contentValidator;

    public Map<String, String> getSettingsMap(Integer siteId){
        if(siteId == null || siteId <= 0){
            throw new JboneException("参数错误");
        }
        Map<String, String> settingsMap = new HashMap<>();
        List<SiteSettings> settingsList = siteSettingsRepository.findBySiteId(siteId);
        if(!CollectionUtils.isEmpty(settingsList)){
            for (SiteSettings settings : settingsList){
                settingsMap.put(settings.getName(),settings.getValue());
            }
        }
        return settingsMap;
    }

    public List<SiteSettingsDO> getSettingsList(Integer siteId){
        if(siteId == null || siteId <= 0){
            throw new JboneException("参数错误");
        }
        return siteSettingsConverter.toDOs(siteSettingsRepository.findBySiteId(siteId));
    }

    public void addOrUpdate(SiteSettingsDO settingsDO){
        if(settingsDO == null){
            throw new JboneException("参数错误");
        }

        contentValidator.checkPermition(settingsDO.getCreator(),settingsDO.getSiteId());

        SiteSettings siteSettings = siteSettingsRepository.findBySiteIdAndName(settingsDO.getSiteId(),settingsDO.getName());
        if(siteSettings == null){
            siteSettingsRepository.save(siteSettingsConverter.toEntity(settingsDO));
        }
    }

    public void addOrUpdate(BatchSaveSiteSettingDO batchSaveSettingDO){
        if(CollectionUtils.isEmpty(batchSaveSettingDO.getSettingsList()) || batchSaveSettingDO.getSiteId() == null || batchSaveSettingDO.getSiteId() <= 0){
            throw new JboneException("参数错误");
        }
        if(!siteRepository.existsById(batchSaveSettingDO.getSiteId())){
            throw new JboneException("站点不存在");
        }
        contentValidator.checkPermition(batchSaveSettingDO.getUserId(),batchSaveSettingDO.getSiteId());
        List<SiteSettings> settingsList = siteSettingsConverter.toEntitys(batchSaveSettingDO.getSettingsList());
        List<SiteSettings> addOrUpdateList = new ArrayList<>();
        for (SiteSettings siteSettings : settingsList){
            siteSettings.setSiteId(batchSaveSettingDO.getSiteId());
            if(siteSettings.getId() == null || siteSettings.getId() <= 0){
                //如果存在name，则取原来的name，并设置新的value
                SiteSettings settings = siteSettingsRepository.findBySiteIdAndName(siteSettings.getSiteId(),siteSettings.getName());
                if(settings != null){
                    settings.setValue(siteSettings.getValue());
                    addOrUpdateList.add(settings);
                }else{
                    addOrUpdateList.add(siteSettings);
                }
            }else{
                addOrUpdateList.add(siteSettings);
            }

        }
        siteSettingsRepository.saveAll(addOrUpdateList);
    }

    public void delete(Long id,Integer userId){
        if(!siteSettingsRepository.existsById(id)){
            throw new JboneException("记录不存在");
        }
        SiteSettings siteSettings = siteSettingsRepository.getOne(id);
        contentValidator.checkPermition(userId,siteSettings.getCreator());
        siteSettingsRepository.delete(siteSettings);
    }

    public SiteSettingsDO getById(Long id){
        if(!siteSettingsRepository.existsById(id)){
            throw new JboneException("记录不存在");
        }
        return siteSettingsConverter.toDO(siteSettingsRepository.getOne(id));
    }


}
