package cn.jbone.cms.core.service;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.constant.SiteSettingConstant;
import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.cms.core.converter.DictionaryConverter;
import cn.jbone.cms.core.converter.PluginConverter;
import cn.jbone.cms.core.dao.entity.Plugin;
import cn.jbone.cms.core.dao.repository.PluginRepository;
import cn.jbone.cms.core.validator.ContentValidator;
import cn.jbone.common.exception.JboneException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

@Service
public class PluginService {
    @Autowired
    private PluginRepository pluginRepository;

    @Autowired
    private PluginConverter pluginConverter;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private DictionaryConverter dictionaryConverter;

    @Autowired
    private ContentValidator contentValidator;

    @Autowired
    private SiteSettingsService siteSettingsService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public PluginDO get(int id){
        Plugin plugin = pluginRepository.getOne(id);
        if(plugin == null){
            throw new JboneException("插件不存在");
        }
        return pluginConverter.toPluginDO(plugin);
    }

    public void addOrUpdate(PluginDO pluginDO){

        contentValidator.checkPermition(pluginDO.getCreator(),pluginDO.getSiteId());

        checkLimit(pluginDO);

        Plugin plugin = pluginConverter.toPlugin(pluginDO);
        if(plugin == null){
            throw new JboneException("插件不存在");
        }
        pluginRepository.save(plugin);
    }

    /**
     * 校验限额
     */
    private void checkLimit(PluginDO pluginDO){
        if(pluginDO.getId() <= 0){
            Map<String, String> settingMap = siteSettingsService.getSettingsMap(pluginDO.getSiteId());
            if(!settingMap.containsKey(SiteSettingConstant.LIMIT_PLUGIN_COUNT)){
                throw new JboneException("本站禁止添加插件，如有疑问请联系管理员.");
            }
            Long limitCount = Long.parseLong(settingMap.get(SiteSettingConstant.LIMIT_PLUGIN_COUNT));
            if(limitCount <= 0){
                logger.warn("超出插件限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "个插件");
            }
            long currentCount = pluginRepository.countBySiteId(pluginDO.getSiteId());
            if(currentCount >= limitCount){
                logger.warn("超出插件限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "个插件");
            }
        }
    }

    public void delete(int id,Integer userId){
        if(!pluginRepository.existsById(id)){
            throw new JboneException("插件不存在");
        }

        Plugin plugin = pluginRepository.getOne(id);

        contentValidator.checkPermition(userId,plugin.getSiteId());

        pluginRepository.deleteById(id);
    }

    public List<PluginDO> findByType(String type,Integer siteId){
        List<Plugin> plugins = pluginRepository.findAllByTypeAndEnableAndSiteIdOrderByOrders(type,1,siteId);
        return pluginConverter.toPluginDOs(plugins);
    }

    public Map<String,List<PluginDO>> findAllValidPlugin(Integer siteId){
        List<Plugin> plugins = pluginRepository.findAllByEnableAndSiteIdOrderByOrders(1,siteId);
        return pluginConverter.toPluginMap(plugins);
    }

    public List<PluginDO> findAll(Integer siteId){
        List<Plugin> plugins = pluginRepository.findAllBySiteIdOrderByOrders(siteId);
        List<PluginDO> pluginDOS = pluginConverter.toPluginDOs(plugins);
        if(!CollectionUtils.isEmpty(pluginDOS)){
            //拼接类型描述
            Map<String, DictionaryItemDO> dictionaryItemDOMap = dictionaryService.getItemsMapByGroupCode(DictionaryConstant.GROUP_PLUGIN_TYPE);
            if(!CollectionUtils.isEmpty(dictionaryItemDOMap)){
                for (PluginDO pluginDO : pluginDOS){
                    if(StringUtils.isNotBlank(pluginDO.getType())){
                        DictionaryItemDO dictionaryItemDO = dictionaryItemDOMap.get(pluginDO.getType());
                        if(dictionaryItemDO == null)continue;
                        pluginDO.setPluginType(dictionaryConverter.toInnerDictionaryItemDO(dictionaryItemDO));
                    }
                }
            }
        }
        return pluginDOS;
    }
}
