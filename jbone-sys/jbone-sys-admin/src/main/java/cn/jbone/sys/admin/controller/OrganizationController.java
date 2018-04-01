package cn.jbone.sys.admin.controller;

import cn.jbone.common.ui.result.Result;
import cn.jbone.common.utils.ResultUtils;
import cn.jbone.sys.core.service.OrganizationService;
import cn.jbone.sys.core.service.model.organization.CreateOrganizationModel;
import cn.jbone.sys.core.service.model.organization.OrganizationBaseInfoModel;
import cn.jbone.sys.core.service.model.organization.TreeOrganizationModel;
import cn.jbone.sys.core.service.model.organization.UpdateOrganizationModel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @RequiresPermissions("sys:organization:read")
    @RequestMapping("index")
    public String index(ModelMap modelMap){
        return "pages/organization/index";
    }

    @RequiresPermissions("sys:organization:read")
    @RequestMapping("getTreeOrganization")
    @ResponseBody
    public Result getTreeOrganization(){
        List<TreeOrganizationModel> treeOrganizationModels = organizationService.findTreeOrganizationModel();
        return ResultUtils.wrapSuccess(treeOrganizationModels);
    }

    @RequiresPermissions("sys:organization:create")
    @RequestMapping("add/{pid}")
    public String toAdd(@PathVariable("pid")int pid,ModelMap modelMap){
        TreeOrganizationModel organizationModel = new TreeOrganizationModel();
        organizationModel.setPid(pid);
        modelMap.put("organizationModel",organizationModel);
        return "pages/organization/add";
    }


    @RequiresPermissions("sys:organization:create")
    @RequestMapping("add")
    @ResponseBody
    public Result add(@Validated CreateOrganizationModel organizationModel, BindingResult bindingResult){
        organizationService.add(organizationModel);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("sys:organization:delete")
    @RequestMapping("delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id")int id){
        organizationService.delete(id);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("sys:organization:update")
    @RequestMapping("update/{id}")
    public String toUpdate(@PathVariable("id")int id,ModelMap modelMap){
        OrganizationBaseInfoModel organizationModel = organizationService.get(id);
        modelMap.put("organizationModel",organizationModel);
        return "pages/organization/update";
    }

    @RequiresPermissions("sys:organization:update")
    @RequestMapping("update")
    @ResponseBody
    public Result update(@Validated UpdateOrganizationModel organizationModel, BindingResult bindingResult){
        organizationService.update(organizationModel);
        return ResultUtils.wrapSuccess();
    }
}
