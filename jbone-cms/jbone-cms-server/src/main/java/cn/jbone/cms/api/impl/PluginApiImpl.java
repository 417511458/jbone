package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.PluginApi;
import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.cms.core.service.PluginService;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PluginApiImpl implements PluginApi {
    @Autowired
    private PluginService pluginService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Result<Void> addOrUpdate(@RequestBody PluginDO pluginDO) {
        try {
            pluginService.addOrUpdate(pluginDO);
        } catch (Exception e) {
            logger.warn("PluginApi addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Integer id) {
        try {
            pluginService.delete(id);
        } catch (Exception e) {
            logger.warn("PluginApi delete error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<PluginDO> get(Integer id) {
        PluginDO pluginDO = null;
        try {
            pluginDO = pluginService.get(id);
        } catch (Exception e) {
            logger.warn("PluginApi get error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(pluginDO);
    }

    @Override
    public Result<List<PluginDO>> findByType(String type) {
        List<PluginDO> list = null;
        try {
            list = pluginService.findByType(type);
        } catch (Exception e) {
            logger.warn("PluginApi findByType error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(list);
    }

    @Override
    public Result<Map<String, List<PluginDO>>> findAllValidPlugin() {
        Map<String, List<PluginDO>> map = null;
        try {
            map = pluginService.findAllValidPlugin();
        } catch (Exception e) {
            logger.warn("PluginApi findAllValidPlugin error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(map);
    }

    @Override
    public Result<List<PluginDO>> getAll() {
        List<PluginDO> list = null;
        try {
            list = pluginService.findAll();
        } catch (Exception e) {
            logger.warn("PluginApi getAll error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(list);
    }
}
