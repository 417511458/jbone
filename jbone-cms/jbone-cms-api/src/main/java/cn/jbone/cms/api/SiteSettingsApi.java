package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.BatchSaveSiteSettingDO;
import cn.jbone.cms.common.dataobject.SiteSettingsDO;
import cn.jbone.cms.common.dataobject.search.SiteSettingsSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/siteSettings")
public interface SiteSettingsApi {

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody SiteSettingsDO settingsDO,@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/batchAddOrUpdate",method = {RequestMethod.POST})
    Result<Void> batchAddOrUpdate(@RequestBody BatchSaveSiteSettingDO batchSaveSettingDO,@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id,@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<SiteSettingsDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/getList",method = {RequestMethod.GET})
    Result<List<SiteSettingsDO>> getList(@RequestParam("siteId") Integer siteId);

    @RequestMapping(value = "/commonRequest",method = {RequestMethod.POST})
    Result<PagedResponseDO<SiteSettingsDO>> commonRequest(@RequestBody SiteSettingsSearchDO settingsSearchDO);

    @RequestMapping(value = "/getMap",method = {RequestMethod.GET})
    Result<Map<String,String>> getMap(@RequestParam("siteId") Integer siteId);

}
