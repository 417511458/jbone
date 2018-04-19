package cn.jbone.sys.admin.controller;

import cn.jbone.common.ui.result.Result;
import cn.jbone.common.utils.ResultUtils;
import cn.jbone.sys.core.dao.domain.RbacSystemEntity;
import cn.jbone.sys.core.service.SystemService;
import cn.jbone.sys.core.service.model.ListModel;
import cn.jbone.sys.core.service.model.system.CreateSystemModel;
import cn.jbone.sys.core.service.model.system.UpdateSystemModel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequiresPermissions("sys:system:read")
    @RequestMapping("/index")
    public String index(){
        return "pages/system/index";
    }

    @RequiresPermissions("sys:system:read")
    @RequestMapping("/list")
    @ResponseBody
    public Result list(ListModel listModel){
        PageRequest pageRequest = new PageRequest(listModel.getPageNumber()-1,listModel.getPageSize(), Sort.Direction.fromString(listModel.getSortOrder()),listModel.getSortName());
        //分页查找
        Page<RbacSystemEntity> page = systemService.findPage(listModel.getSearchText(),pageRequest);
        return ResultUtils.wrapSuccess(page.getTotalElements(),page.getContent());
    }

    @RequiresPermissions("sys:system:create")
    @RequestMapping("/create")
    @ResponseBody
    public Result create(@Validated CreateSystemModel createSystemModel, BindingResult bindingResult){
        systemService.save(createSystemModel);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("sys:system:create")
    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/system/create";
    }

    @RequiresPermissions("sys:system:update")
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        RbacSystemEntity systemEntity = systemService.get(Integer.parseInt(id));
        modelMap.put("system",systemEntity);
        return "pages/system/update";
    }

    @RequiresPermissions("sys:system:update")
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@Validated UpdateSystemModel updateSystemModel, BindingResult bindingResult){
        systemService.update(updateSystemModel);
        return ResultUtils.wrapSuccess();
    }


    @RequiresPermissions("sys:system:delete")
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Result delete(@PathVariable("ids")String ids){
        systemService.delete(ids);
        return ResultUtils.wrapSuccess();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result get(@PathVariable("id")String id){
        RbacSystemEntity systemEntity = systemService.get(Integer.parseInt(id));
        return ResultUtils.wrapSuccess(systemEntity);
    }
}
