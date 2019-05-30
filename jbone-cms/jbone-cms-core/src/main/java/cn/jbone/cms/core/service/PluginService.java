package cn.jbone.cms.core.service;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.cms.core.converter.PluginConverter;
import cn.jbone.cms.core.dao.entity.Plugin;
import cn.jbone.cms.core.dao.repository.PluginRepository;
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

    public PluginDO get(int id){
        Plugin plugin = pluginRepository.getOne(id);
        if(plugin == null){
            throw new ObjectNotFoundException("插件不存在");
        }
        return pluginConverter.toPluginDO(plugin);
    }

    public void addOrUpdate(PluginDO pluginDO){
        Plugin plugin = pluginConverter.toPlugin(pluginDO);
        if(plugin == null){
            throw new ObjectNotFoundException("参数错误");
        }
        pluginRepository.save(plugin);
    }

    public void delete(int id){
        if(!pluginRepository.existsById(id)){
            throw new ObjectNotFoundException("插件不存在");
        }
        pluginRepository.deleteById(id);
    }

    public List<PluginDO> findByType(String type){
        List<Plugin> plugins = pluginRepository.findAllByTypeAndEnableOrderByOrders(type,1);
        return pluginConverter.toPluginDOs(plugins);
    }

    public Map<String,List<PluginDO>> findAllValidPlugin(){
        List<Plugin> plugins = pluginRepository.findAllByEnableOrderByOrders(1);
        return pluginConverter.toPluginMap(plugins);
    }

    public List<PluginDO> findAll(){
        List<Plugin> plugins = pluginRepository.findAll(Sort.by(Sort.Order.by("orders")));
        List<PluginDO> pluginDOS = pluginConverter.toPluginDOs(plugins);
        if(!CollectionUtils.isEmpty(pluginDOS)){
            //拼接类型描述
            Map<String, DictionaryItemDO> dictionaryItemDOMap = dictionaryService.getItemsMapByGroupCode(DictionaryConstant.GROUP_PLUGIN_TYPE);
            if(!CollectionUtils.isEmpty(dictionaryItemDOMap)){
                for (PluginDO pluginDO : pluginDOS){
                    if(StringUtils.isNotBlank(pluginDO.getType())){
                        DictionaryItemDO dictionaryItemDO = dictionaryItemDOMap.get(pluginDO.getType());
                        if(dictionaryItemDO == null)continue;
                        PluginDO.PluginTypeDO pluginTypeDO = new PluginDO.PluginTypeDO();
                        pluginTypeDO.setName(dictionaryItemDO.getDictName());
                        pluginTypeDO.setPrompt(dictionaryItemDO.getDictPrompt());
                        pluginTypeDO.setValue(dictionaryItemDO.getDictValue());
                        pluginDO.setPluginType(pluginTypeDO);
                    }
                }
            }
        }
        return pluginDOS;
    }
}
