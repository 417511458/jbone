package cn.jbone.cms.api;

import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.cms.common.dataobject.search.TagSearchDO;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tag")
public interface TagApi {

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    Result<List<TagDO>> getAll(@RequestParam("siteId") Integer siteId);

    @RequestMapping(value = "/findTagCloud",method = {RequestMethod.GET})
    Result<List<TagDO>> findTagCloud(@RequestParam("siteId") Integer siteId);

    @RequestMapping(value = "/getByName",method = {RequestMethod.GET})
    Result<List<TagDO>> getByName(@RequestParam("name")String name,@RequestParam("siteId") Integer siteId);

    @RequestMapping(value = "/getById",method = {RequestMethod.GET})
    Result<TagDO> getById(@RequestParam("id")Long id);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id")Long id,@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody TagDO tagDO,@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/commonRequest",method = {RequestMethod.POST})
    Result<PagedResponseDO<TagDO>> commonRequest(@RequestBody TagSearchDO tagSearchDO);
}
