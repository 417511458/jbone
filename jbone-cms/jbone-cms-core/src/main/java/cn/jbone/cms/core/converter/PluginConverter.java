package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.cms.core.dao.entity.Plugin;
import cn.jbone.cms.core.dao.repository.PluginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PluginConverter {
    @Autowired
    private PluginRepository pluginRepository;

    public PluginDO toPluginDO(Plugin plugin){
        if(plugin == null){
            return null;
        }
        PluginDO pluginDO = new PluginDO();
        pluginDO.setContent(plugin.getContent());
        pluginDO.setEnable(plugin.getEnable());
        pluginDO.setId(plugin.getId());
        pluginDO.setName(plugin.getName());
        pluginDO.setOrders(plugin.getOrders());
        pluginDO.setType(plugin.getType());
        pluginDO.setSiteId(plugin.getSiteId());
        return pluginDO;
    }

    public List<PluginDO> toPluginDOs(List<Plugin> plugins){
        if(CollectionUtils.isEmpty(plugins)){
            return null;
        }

        List<PluginDO> list = new ArrayList<>();
        for (Plugin plugin : plugins){
            PluginDO pluginDO = toPluginDO(plugin);
            if(pluginDO != null){
                list.add(pluginDO);
            }
        }
        return list;
    }

    /**
     * 根据type分组插件 Map<type,List<PluginDO>>
     * @param plugins
     * @return
     */
    public Map<String,List<PluginDO>> toPluginMap(List<Plugin> plugins){
        if(CollectionUtils.isEmpty(plugins)){
            return null;
        }

        Map<String,List<PluginDO>> map = new HashMap<>();
        for (Plugin plugin : plugins){
            PluginDO pluginDO = toPluginDO(plugin);
            if(pluginDO == null){
                continue;
            }
            List<PluginDO> pluginDOS = map.get(plugin.getType());
            if(CollectionUtils.isEmpty(pluginDOS)){
                pluginDOS = new ArrayList<>();
            }
            pluginDOS.add(pluginDO);
            map.put(plugin.getType(),pluginDOS);
        }
        return map;
    }

    public Plugin toPlugin(PluginDO pluginDO){
        if(pluginDO == null){
            return null;
        }

        Plugin plugin = null;
        if(pluginDO.getId() > 0 ){
            plugin = pluginRepository.getOne(pluginDO.getId());
        }

        if(plugin == null){
            plugin = new Plugin();
        }

        plugin.setContent(pluginDO.getContent());
        plugin.setEnable(pluginDO.getEnable());
        plugin.setId(pluginDO.getId());
        plugin.setName(pluginDO.getName());
        plugin.setOrders(pluginDO.getOrders());
        plugin.setType(pluginDO.getType());
        plugin.setSiteId(pluginDO.getSiteId());
        return plugin;
    }

    public List<Plugin> toPlugins(List<PluginDO> pluginDOS){
        if(CollectionUtils.isEmpty(pluginDOS)){
            return null;
        }
        List<Plugin> plugins = new ArrayList<>();
        for (PluginDO pluginDO : pluginDOS){
            Plugin plugin = toPlugin(pluginDO);
            if(plugin != null){
                plugins.add(plugin);
            }
        }
        return plugins;
    }


}
