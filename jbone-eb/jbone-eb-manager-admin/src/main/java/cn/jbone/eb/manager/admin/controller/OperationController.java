package cn.jbone.eb.manager.admin.controller;

import cn.jbone.common.service.bo.SearchListBO;
import cn.jbone.common.ui.result.Result;
import cn.jbone.eb.manager.core.service.OperationService;
import cn.jbone.eb.manager.core.service.bo.operation.CreateOperationBO;
import cn.jbone.eb.manager.core.service.bo.operation.UpdateOperationBO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @RequiresPermissions("eb:manager:operation:read")
    @RequestMapping("/index")
    public String index(){
        return "pages/operation/index";
    }

    @RequiresPermissions("eb:manager:operation:read")
    @RequestMapping("/list")
    @ResponseBody
    public Result list(SearchListBO listBO){
        return operationService.findByPage(listBO);
    }

    @RequiresPermissions("eb:manager:operation:create")
    @RequestMapping("/create")
    @ResponseBody
    public Result create(@Validated CreateOperationBO createOperationBO, BindingResult bindingResult){
        return operationService.create(createOperationBO);
    }

    @RequiresPermissions("eb:manager:operation:create")
    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/operation/create";
    }

    @RequiresPermissions("eb:manager:operation:update")
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")int id, ModelMap modelMap){
        return "pages/operation/update";
    }

    @RequiresPermissions("eb:manager:operation:update")
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@Validated UpdateOperationBO updateOperationBO, BindingResult bindingResult){
        return operationService.update(updateOperationBO);
    }


    @RequiresPermissions("eb:manager:operation:delete")
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Result delete(@PathVariable("ids")String ids){
        return operationService.delete(ids);
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result get(@PathVariable("id")int id){
        return operationService.get(id);
    }
}
