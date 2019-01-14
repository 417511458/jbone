package cn.jbone.sys.admin.controller;

import cn.jbone.common.ui.result.Result;
import cn.jbone.common.utils.ResultUtils;
import cn.jbone.sys.core.dao.domain.RbacSystemEntity;
import cn.jbone.sys.core.service.MenuService;
import cn.jbone.sys.core.service.SystemService;
import cn.jbone.sys.core.service.model.menu.CreateMenuModel;
import cn.jbone.sys.core.service.model.menu.TreeMenuModel;
import cn.jbone.sys.core.service.model.menu.UpdateMenuModel;
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
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private SystemService systemService;

    @Autowired
    private MenuService menuService;

    @RequiresPermissions("sys:menu:read")
    @RequestMapping("index")
    public String index(ModelMap modelMap){
        List<RbacSystemEntity> systemEntities = systemService.findAll();
        modelMap.put("systemList",systemEntities);
        return "pages/menu/index";
    }

    @RequiresPermissions("sys:menu:read")
    @RequestMapping("getTreeMenu/{systemId}")
    @ResponseBody
    public Result getTreeMenu(@PathVariable("systemId")int systemId){
        List<TreeMenuModel> menuModelList = menuService.findBySystemId(systemId);
        return ResultUtils.wrapSuccess(menuModelList);
    }

    @RequiresPermissions("sys:menu:create")
    @RequestMapping("add/{systemId}")
    public String toAdd(@PathVariable("systemId")int systemId,ModelMap modelMap){
        TreeMenuModel menuModel = new TreeMenuModel();
        menuModel.setSystemId(systemId);
        modelMap.put("menuModel",menuModel);
        return "pages/menu/add";
    }

    @RequiresPermissions("sys:menu:create")
    @RequestMapping("addChild/{id}/{systemId}")
    public String toAddChild(@PathVariable("id")int id,@PathVariable("systemId")int systemId,ModelMap modelMap){
        TreeMenuModel menuModel = new TreeMenuModel();
        menuModel.setSystemId(systemId);
        menuModel.setPid(id);
        modelMap.put("menuModel",menuModel);
        return "pages/menu/add";
    }

    @RequiresPermissions("sys:menu:create")
    @RequestMapping("add")
    @ResponseBody
    public Result add(@Validated CreateMenuModel menuModel, BindingResult bindingResult){
        menuService.add(menuModel);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("sys:menu:delete")
    @RequestMapping("delete/{id}")
    @ResponseBody
    public Result delete(@PathVariable("id")int id){
        menuService.delete(id);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("sys:menu:update")
    @RequestMapping("update/{id}")
    public String toUpdate(@PathVariable("id")int id,ModelMap modelMap){
        TreeMenuModel menuModel = menuService.get(id);
        modelMap.put("menuModel",menuModel);
        return "pages/menu/update";
    }

    @RequiresPermissions("sys:menu:update")
    @RequestMapping("update")
    @ResponseBody
    public Result update(@Validated UpdateMenuModel menuModel,BindingResult bindingResult){
        menuService.update(menuModel);
        return ResultUtils.wrapSuccess();
    }
}
