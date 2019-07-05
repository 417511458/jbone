package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.PluginApi;
import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.cms.core.service.PluginService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PluginApiImpl implements PluginApi {
    @Autowired
    private PluginService pluginService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Result<Void> addOrUpdate(@RequestBody PluginDO pluginDO, @RequestHeader("userId") Integer userId) {
        try {
            pluginDO.setCreator(userId);
            pluginService.addOrUpdate(pluginDO);
        } catch (JboneException e) {
            logger.warn("PluginApi addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("PluginApi addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Integer id, @RequestHeader("userId") Integer userId) {
        try {
            pluginService.delete(id,userId);
        } catch (JboneException e) {
            logger.warn("PluginApi delete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("PluginApi delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<PluginDO> get(Integer id) {
        PluginDO pluginDO = null;
        try {
            pluginDO = pluginService.get(id);
        } catch (JboneException e) {
            logger.warn("PluginApi get error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("PluginApi get error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(pluginDO);
    }

    @Override
    public Result<List<PluginDO>> findByType(String type,Integer siteId) {
        List<PluginDO> list = null;
        try {
            list = pluginService.findByType(type,siteId);
        } catch (JboneException e) {
            logger.warn("PluginApi findByType error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("PluginApi findByType error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(list);
    }

    @Override
    public Result<Map<String, List<PluginDO>>> findAllValidPlugin(Integer siteId) {
        Map<String, List<PluginDO>> map = null;
        try {
            map = pluginService.findAllValidPlugin(siteId);
        } catch (JboneException e) {
            logger.warn("PluginApi findAllValidPlugin error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("PluginApi findAllValidPlugin error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(map);
    }

    @Override
    public Result<List<PluginDO>> getAll(Integer siteId) {
        List<PluginDO> list = null;
        try {
            list = pluginService.findAll(siteId);
        } catch (JboneException e) {
            logger.warn("PluginApi getAll error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("PluginApi getAll error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(list);
    }
}
