package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@RequestMapping("/plugin")
public interface PluginApi {
    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody PluginDO pluginDO);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Integer id);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<PluginDO> get(@RequestParam("id") Integer id);

    @RequestMapping(value = "/findByType",method = {RequestMethod.GET})
    Result<List<PluginDO>> findByType(@RequestParam("type") String type);

    @RequestMapping(value = "/findAllValidPlugin",method = {RequestMethod.GET})
    Result<Map<String,List<PluginDO>>> findAllValidPlugin();

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    Result<List<PluginDO>> getAll();



}
