package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/tag")
public interface TagApi {

    @RequestMapping(value = "/getAll",method = {RequestMethod.POST,RequestMethod.GET})
    Result<List<TagDO>> getAll();

    @RequestMapping(value = "/getByName",method = {RequestMethod.POST,RequestMethod.GET})
    Result<List<TagDO>> getByName(@RequestParam("name")String name);

    @RequestMapping(value = "/getById",method = {RequestMethod.POST,RequestMethod.GET})
    Result<TagDO> getById(@RequestParam("id")Long id);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("name")Long id);

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody TagDO tagDO);
}
