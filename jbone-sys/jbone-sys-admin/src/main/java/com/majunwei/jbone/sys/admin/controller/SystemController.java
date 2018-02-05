package com.majunwei.jbone.sys.admin.controller;

import com.majunwei.jbone.common.ui.result.Result;
import com.majunwei.jbone.common.utils.ResultUtils;
import com.majunwei.jbone.sys.dao.domain.RbacSystemEntity;
import com.majunwei.jbone.sys.service.SystemService;
import com.majunwei.jbone.sys.service.model.ListModel;
import com.majunwei.jbone.sys.service.model.system.CreateSystemModel;
import com.majunwei.jbone.sys.service.model.system.UpdateSystemModel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
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

    @RequiresRoles("admin")
    @RequestMapping("/index")
    public String index(){
        return "pages/system/index";
    }

    @RequiresRoles("admin")
    @RequestMapping("/list")
    @ResponseBody
    public Result list(ListModel listModel){
        PageRequest pageRequest = new PageRequest(listModel.getPageNumber()-1,listModel.getPageSize(), Sort.Direction.fromString(listModel.getSortOrder()),listModel.getSortName());
        //分页查找
        Page<RbacSystemEntity> page = systemService.findPage(listModel.getSearchText(),pageRequest);
        return ResultUtils.wrapSuccess(page.getTotalElements(),page.getContent());
    }


    @RequestMapping("/create")
    @ResponseBody
    public Result create(@Validated CreateSystemModel createSystemModel, BindingResult bindingResult){
        systemService.save(createSystemModel);
        return ResultUtils.wrapSuccess();
    }

    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/system/create";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap modelMap){
        RbacSystemEntity systemEntity = systemService.get(Integer.parseInt(id));
        modelMap.put("system",systemEntity);
        return "pages/system/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@Validated UpdateSystemModel updateSystemModel, BindingResult bindingResult){
        systemService.update(updateSystemModel);
        return ResultUtils.wrapSuccess();
    }

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
