package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/template")
public interface TemplateApi {

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody TemplateDO templateDO);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<TemplateDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/getAll",method = {RequestMethod.GET})
    Result<List<TemplateDO>> getAll();

}
