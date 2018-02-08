package com.majunwei.jbone.sys.admin.controller;

import com.majunwei.jbone.common.ui.result.Result;
import com.majunwei.jbone.common.utils.ResultUtils;
import com.majunwei.jbone.sys.dao.domain.*;
import com.majunwei.jbone.sys.service.PermissionService;
import com.majunwei.jbone.sys.service.RoleService;
import com.majunwei.jbone.sys.service.SystemService;
import com.majunwei.jbone.sys.service.UserService;
import com.majunwei.jbone.sys.service.model.ListModel;
import com.majunwei.jbone.sys.service.model.common.AssignPermissionModel;
import com.majunwei.jbone.sys.service.model.user.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
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

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private SystemService systemService;
    @Autowired
    private PermissionService permissionService;

    @Description("用户管理首页")
    @RequiresRoles("admin")
    @RequestMapping("/index")
    public String index(){
        return "pages/user/index";
    }

    @Description("用户管理分页查询")
    @RequiresRoles("admin")
    @RequestMapping("/list")
    @ResponseBody
    public Result list(ListModel listModel){
        PageRequest pageRequest = new PageRequest(listModel.getPageNumber()-1,listModel.getPageSize(), Sort.Direction.fromString(listModel.getSortOrder()),listModel.getSortName());
        //分页查找
        Page<RbacUserEntity> page = userService.findPage(listModel.getSearchText(),pageRequest);
        List<UserBaseInfoModel> list = userService.getUserBaseInfos(page.getContent());
        return ResultUtils.wrapSuccess(page.getTotalElements(),list);
    }

    @Description("跳转至新增用户页面")
    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/user/create";
    }

    @Description("执行新增用户")
    @RequestMapping("/create")
    @ResponseBody
    public Result create(@Validated CreateUserModel userModel, BindingResult bindingResult){
        userService.save(userModel);
        return ResultUtils.wrapSuccess();
    }

    @Description("跳转至更新用户页面")
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap model){
        RbacUserEntity userEntity = userService.findById(Integer.parseInt(id));
        UpdateUserModel userModel = new UpdateUserModel();
        BeanUtils.copyProperties(userEntity,userModel);
        model.put("userEntity",userModel);
        return "pages/user/update";
    }

    @Description("执行更新用户")
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@Validated UpdateUserModel userModel, BindingResult bindingResult){
        userService.update(userModel);
        return ResultUtils.wrapSuccess();
    }

    @Description("批量删除用户")
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Result delete(@PathVariable("ids")String ids){
        userService.delete(ids);
        return ResultUtils.wrapSuccess();
    }

    @Description("获取用户详情")
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result get(@PathVariable("id")String id){
        RbacUserEntity userEntity = userService.findById(Integer.parseInt(id));
        return ResultUtils.wrapSuccess(userEntity);
    }

    @Description("跳转至分配角色页面")
    @RequestMapping("/toAssignRole/{id}")
    public String toAssignRole(@PathVariable("id")String id,ModelMap modelMap){
        RbacUserEntity userEntity = userService.findById(Integer.parseInt(id));
        modelMap.put("userRoles",roleService.getSimpleModels(userEntity.getRoles()));
        modelMap.put("allRoles",roleService.getSimpleModels(roleService.findAll()));
        modelMap.put("userId",id);
        return "pages/user/assignRole";
    }

    @Description("执行分配角色")
    @RequestMapping("/doAssignRole")
    @ResponseBody
    public Result doAssignRole(AssignRoleModel assignRoleModel){
        userService.assignRole(assignRoleModel);
        return ResultUtils.wrapSuccess();
    }

    @Description("跳转至分配菜单页面")
    @RequestMapping("toAssignMenu/{userId}")
    public String toAssignMenu(@PathVariable("userId")String userId,ModelMap modelMap){
        List<RbacSystemEntity> systemEntities = systemService.findAll();
        modelMap.put("systemList",systemEntities);
        modelMap.put("userId",userId);

        RbacUserEntity userEntity = userService.findById(Integer.parseInt(userId));
        List<RbacMenuEntity> menuEntityList = userEntity.getMenus();
        List<Integer> menuIds = new ArrayList<>();
        if(menuEntityList != null && !menuEntityList.isEmpty()){
            for (RbacMenuEntity menuEntity : menuEntityList){
                menuIds.add(menuEntity.getId());
            }
        }
        modelMap.put("menuIds",menuIds);

        return "pages/user/assignMenu";
    }

    @Description("执行分配菜单")
    @RequestMapping("doAssignMenu")
    @ResponseBody
    public Result doAssignMenu(@Validated AssignMenuModel menuModel,BindingResult bindingResult){
        userService.assignMenu(menuModel);
        return ResultUtils.wrapSuccess();
    }

    @Description("跳转至分配菜单页面")
    @RequestMapping("toAssignPermission/{userId}")
    public String toAssignPermission(@PathVariable("userId")String userId,ModelMap modelMap){
        List<RbacSystemEntity> systemEntities = systemService.findAll();
        modelMap.put("systemList",systemEntities);
        modelMap.put("id",userId);

        RbacUserEntity userEntity = userService.findById(Integer.parseInt(userId));
        List<RbacPermissionEntity> permissions = userEntity.getPermissions();

        modelMap.put("permissions",permissionService.getBaseInfos(permissions));

        modelMap.put("commitUrl", "/user/doAssignPermission");

        return "pages/common/assignPermission";
    }

    @Description("执行分配菜单")
    @RequestMapping("doAssignPermission")
    @ResponseBody
    public Result doAssignPermission(@Validated AssignPermissionModel assignPermissionModel, BindingResult bindingResult){
        userService.assignPermission(assignPermissionModel);
        return ResultUtils.wrapSuccess();
    }
}
