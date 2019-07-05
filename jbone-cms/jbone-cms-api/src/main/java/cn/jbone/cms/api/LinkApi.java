package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/link")
public interface LinkApi {
    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody LinkDO linkDO, @RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id, @RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/batchDelete",method = {RequestMethod.DELETE})
    Result<Void> batchDelete(@RequestParam("ids") String ids, @RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<LinkDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    Result<List<LinkDO>> getAll(@RequestParam("siteId") Integer siteId);

}
