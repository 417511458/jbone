package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.BatchSaveSettingDO;
import cn.jbone.cms.common.dataobject.SettingsDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/settings")
public interface SettingsApi {

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody SettingsDO settingsDO);

    @RequestMapping(value = "/batchAddOrUpdate",method = {RequestMethod.POST})
    Result<Void> batchAddOrUpdate(@RequestBody BatchSaveSettingDO batchSaveSettingDO);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id);

    @RequestMapping(value = "/batchDelete",method = {RequestMethod.DELETE})
    Result<Void> batchDelete(@RequestParam("String") String ids);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<SettingsDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/getList",method = {RequestMethod.GET})
    Result<List<SettingsDO>> getList();

    @RequestMapping(value = "/getMap",method = {RequestMethod.GET})
    Result<Map<String,String>> getMap();

}
