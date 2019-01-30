package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.SettingsApi;
import cn.jbone.cms.common.dataobject.SettingsDO;
import cn.jbone.cms.core.service.SettingsService;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SettingsApiImpl implements SettingsApi {

    @Autowired
    private SettingsService settingsService;

    @Override
    public Result<Void> addOrUpdate(SettingsDO settingsDO) {
        try {
            settingsService.addOrUpdate(settingsDO);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            settingsService.delete(id);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> batchDelete(String ids) {
        try {
            settingsService.batchDelete(ids);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<SettingsDO> get(Long id) {
        SettingsDO settingsDO = null;
        try {
            settingsDO = settingsService.get(id);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(settingsDO);
    }

    @Override
    public Result<List<SettingsDO>> getList() {
        List<SettingsDO> settingsDOList = null;
        try {
            settingsDOList = settingsService.getSettingsList();
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(settingsDOList);
    }

    @Override
    public Result<Map<String, SettingsDO>> getMap() {
        Map<String, SettingsDO> settingsDOMap = null;
        try {
            settingsDOMap = settingsService.getSettingsMap();
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(settingsDOMap);
    }
}
