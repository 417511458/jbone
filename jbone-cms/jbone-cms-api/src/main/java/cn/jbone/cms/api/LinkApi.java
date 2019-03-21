package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/link")
public interface LinkApi {
    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody LinkDO linkDO);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id);

    @RequestMapping(value = "/batchDelete",method = {RequestMethod.DELETE})
    Result<Void> batchDelete(@RequestParam("ids") String ids);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<LinkDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    Result<List<LinkDO>> getAll();

}
