package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.cms.common.dataobject.search.SiteSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/site")
public interface SiteApi {

    @RequestMapping(value = "/getByDomain",method = {RequestMethod.GET})
    Result<SiteDO> getByDomain(@RequestParam("domain") String domain);

    @RequestMapping(value = "/getById",method = {RequestMethod.GET})
    Result<SiteDO> getById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/getByUserId",method = {RequestMethod.GET})
    Result<List<SiteDO>> getByUserId(@RequestParam("userId") Integer userId);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Integer id);

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody SiteDO siteDO);

    @RequestMapping(value = "/commonRequest",method = {RequestMethod.POST})
    Result<PagedResponseDO<SiteDO>> commonRequest(@RequestBody SiteSearchDO siteSearchDO);
}
