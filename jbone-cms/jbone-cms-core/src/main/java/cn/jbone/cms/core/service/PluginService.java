package cn.jbone.cms.core.service;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.cms.core.converter.DictionaryConverter;
import cn.jbone.cms.core.converter.PluginConverter;
import cn.jbone.cms.core.dao.entity.Plugin;
import cn.jbone.cms.core.dao.repository.PluginRepository;
import cn.jbone.cms.core.validator.ContentValidator;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.exception.ObjectNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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


    public PluginDO get(int id){
        Plugin plugin = pluginRepository.getOne(id);
        if(plugin == null){
            throw new JboneException("插件不存在");
        }
        return pluginConverter.toPluginDO(plugin);
    }

    public void addOrUpdate(PluginDO pluginDO){

        contentValidator.checkPermition(pluginDO.getCreator(),pluginDO.getSiteId());

        Plugin plugin = pluginConverter.toPlugin(pluginDO);
        if(plugin == null){
            throw new JboneException("插件不存在");
        }
        pluginRepository.save(plugin);
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
