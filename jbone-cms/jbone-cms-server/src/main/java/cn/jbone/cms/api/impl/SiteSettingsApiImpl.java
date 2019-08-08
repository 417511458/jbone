package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.SiteSettingsApi;
import cn.jbone.cms.common.dataobject.BatchSaveSiteSettingDO;
import cn.jbone.cms.common.dataobject.SiteSettingsDO;
import cn.jbone.cms.common.dataobject.search.SiteSettingsSearchDO;
import cn.jbone.cms.core.service.SiteSettingsService;
import cn.jbone.common.dataobject.PagedResponseDO;
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
public class SiteSettingsApiImpl implements SiteSettingsApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SiteSettingsService siteSettingsService;

    @Override
    public Result<Void> addOrUpdate(@RequestBody SiteSettingsDO settingsDO,@RequestHeader("userId") Integer userId) {
        try {
            settingsDO.setCreator(userId);
            siteSettingsService.addOrUpdate(settingsDO);
        } catch (JboneException e) {
            logger.warn("SiteSettings addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("SiteSettings addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> batchAddOrUpdate(@RequestBody BatchSaveSiteSettingDO batchSaveSettingDO,@RequestHeader("userId") Integer userId) {
        try {
            batchSaveSettingDO.setUserId(userId);
            siteSettingsService.addOrUpdate(batchSaveSettingDO);
        } catch (JboneException e) {
            logger.warn("SiteSettings batchAddOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("SiteSettings batchAddOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id,@RequestHeader("userId") Integer userId) {
        try {
            siteSettingsService.delete(id,userId);
        } catch (JboneException e) {
            logger.warn("SiteSettings delete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("SiteSettings delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<SiteSettingsDO> get(Long id) {
        SiteSettingsDO siteSettingsDO = null;
        try {
            siteSettingsDO = siteSettingsService.getById(id);
        } catch (JboneException e) {
            logger.warn("SiteSettings get error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("SiteSettings get error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(siteSettingsDO);
    }

    @Override
    public Result<List<SiteSettingsDO>> getList(Integer siteId) {
        List<SiteSettingsDO> siteSettingsDOs = null;
        try {
            siteSettingsDOs = siteSettingsService.getSettingsList(siteId);
        } catch (JboneException e) {
            logger.warn("SiteSettings getList error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("SiteSettings getList error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(siteSettingsDOs);
    }

    @Override
    public Result<Map<String, String>> getMap(Integer siteId) {
        Map<String, String> siteSettingsMap = null;
        try {
            siteSettingsMap = siteSettingsService.getSettingsMap(siteId);
        } catch (JboneException e) {
            logger.warn("SiteSettings getMap error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("SiteSettings getMap error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(siteSettingsMap);
    }

    @Override
    public Result<PagedResponseDO<SiteSettingsDO>> commonRequest(@RequestBody SiteSettingsSearchDO settingsSearchDO) {
        PagedResponseDO<SiteSettingsDO> pagedResponseDO = null;
        try {
            pagedResponseDO = siteSettingsService.commonRequest(settingsSearchDO);
        } catch (JboneException e) {
            logger.warn("SiteSettings settingsSearchDO error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("SiteSettings settingsSearchDO error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(pagedResponseDO);
    }
}
