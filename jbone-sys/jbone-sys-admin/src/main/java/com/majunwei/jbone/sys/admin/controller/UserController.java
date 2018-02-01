package com.majunwei.jbone.sys.admin.controller;

import com.majunwei.jbone.common.ui.result.Result;
import com.majunwei.jbone.common.utils.ResultUtils;
import com.majunwei.jbone.sys.dao.domain.RbacRoleEntity;
import com.majunwei.jbone.sys.dao.domain.RbacUserEntity;
import com.majunwei.jbone.sys.service.RoleService;
import com.majunwei.jbone.sys.service.UserService;
import com.majunwei.jbone.sys.service.model.ListModel;
import com.majunwei.jbone.sys.service.model.user.AssignRoleModel;
import com.majunwei.jbone.sys.service.model.user.CreateUserModel;
import com.majunwei.jbone.sys.service.model.user.UpdateUserModel;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequiresRoles("admin")
    @RequestMapping("/index")
    public String index(){
        return "pages/user/index";
    }

    @RequiresRoles("admin")
    @RequestMapping("/list")
    @ResponseBody
    public Result list(ListModel listModel){
        PageRequest pageRequest = new PageRequest(listModel.getPageNumber()-1,listModel.getPageSize(), Sort.Direction.fromString(listModel.getSortOrder()),listModel.getSortName());
        //分页查找
        Page<RbacUserEntity> page = userService.findPage(listModel.getSearchText(),pageRequest);
        return ResultUtils.wrapSuccess(page.getTotalElements(),page.getContent());
    }


    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/user/create";
    }

    @RequestMapping("/create")
    @ResponseBody
    public Result create(@Validated CreateUserModel userModel, BindingResult bindingResult){
        userService.save(userModel);
        return ResultUtils.wrapSuccess();
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, ModelMap model){
        RbacUserEntity userEntity = userService.findById(Integer.parseInt(id));
        UpdateUserModel userModel = new UpdateUserModel();
        BeanUtils.copyProperties(userEntity,userModel);
        model.put("userEntity",userModel);
        return "pages/user/update";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(@Validated UpdateUserModel userModel, BindingResult bindingResult){
        userService.update(userModel);
        return ResultUtils.wrapSuccess();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Result delete(@PathVariable("ids")String ids){
        userService.delete(ids);
        return ResultUtils.wrapSuccess();
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result get(@PathVariable("id")String id){
        RbacUserEntity userEntity = userService.findById(Integer.parseInt(id));
        return ResultUtils.wrapSuccess(userEntity);
    }

    @RequestMapping("/toAssignRole/{id}")
    public String toAssignRole(@PathVariable("id")String id,ModelMap modelMap){
        RbacUserEntity userEntity = userService.findById(Integer.parseInt(id));
        modelMap.put("userRoles",roleService.getSimpleModels(userEntity.getRoles()));
        modelMap.put("allRoles",roleService.getSimpleModels(roleService.findAll()));
        modelMap.put("userId",id);
        return "pages/user/assignRole";
    }

    @RequestMapping("/doAssignRole")
    @ResponseBody
    public Result doAssignRole(AssignRoleModel assignRoleModel){
        userService.assignRole(assignRoleModel);
        return ResultUtils.wrapSuccess();
    }


    @RequestMapping("toAssignMenu")
    public String toAssignMenu(){
        return "pages/user/assignMenu";
    }
}
