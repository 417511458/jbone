package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.BatchSaveSiteAdminDO;
import cn.jbone.common.rpc.Result;
import cn.jbone.sys.common.UserResponseDO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/siteAdmin")
public interface SiteAdminApi {


    @RequestMapping(value = "/getBySiteId",method = {RequestMethod.GET})
    Result<List<UserResponseDO>> getBySiteId(@RequestParam("siteId") Integer siteId);

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody BatchSaveSiteAdminDO batchSaveSiteAdminDO);

}
