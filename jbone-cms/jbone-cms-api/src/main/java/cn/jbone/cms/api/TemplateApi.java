package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.search.TemplateSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/template")
public interface TemplateApi {

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody TemplateDO templateDO,@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id,@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<TemplateDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/commonRequest",method = {RequestMethod.POST})
    Result<PagedResponseDO<TemplateDO>> commonRequest(@RequestBody TemplateSearchDO templateSearchDO);

}
