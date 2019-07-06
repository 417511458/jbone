package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.SettingsApi;
import cn.jbone.cms.common.dataobject.BatchSaveSettingDO;
import cn.jbone.cms.common.dataobject.SettingsDO;
import cn.jbone.cms.core.service.SettingsService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SettingsApiImpl implements SettingsApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SettingsService settingsService;

    @Override
    public Result<Void> addOrUpdate(@RequestBody SettingsDO settingsDO) {
        try {
            settingsService.addOrUpdate(settingsDO);
        } catch (JboneException e) {
            logger.warn("Settings addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Settings addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            settingsService.delete(id);
        } catch (JboneException e) {
            logger.warn("Settings delete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Settings delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> batchDelete(String ids) {
        try {
            settingsService.batchDelete(ids);
        } catch (JboneException e) {
            logger.warn("Settings batchDelete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Settings batchDelete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<SettingsDO> get(Long id) {
        SettingsDO settingsDO = null;
        try {
            settingsDO = settingsService.get(id);
        } catch (JboneException e) {
            logger.warn("Settings get error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Settings get error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(settingsDO);
    }

    @Override
    public Result<List<SettingsDO>> getList() {
        List<SettingsDO> settingsDOList = null;
        try {
            settingsDOList = settingsService.getSettingsList();
        } catch (JboneException e) {
            logger.warn("Settings getList error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Settings getList error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(settingsDOList);
    }

    @Override
    public Result<Map<String, String>> getMap() {
        Map<String, String> settingsDOMap = null;
        try {
            settingsDOMap = settingsService.getSettingsMap();
        } catch (JboneException e) {
            logger.warn("Settings getMap error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Settings getMap error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(settingsDOMap);
    }

    @Override
    public Result<Void> batchAddOrUpdate(@RequestBody BatchSaveSettingDO batchSaveSettingDO) {
        try {
            settingsService.addOrUpdate(batchSaveSettingDO.getSettingsList());
        } catch (JboneException e) {
            logger.warn("Settings addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Settings addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }
}
