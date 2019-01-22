package cn.jbone.sys.admin.controller;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sys.common.UserResponseDO;
import cn.jbone.sys.core.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.ModelMap;

public class CommonController {

    public void setCurrentUser(UserService userService, ModelMap modelMap, JboneConfiguration jboneConfiguration){
        UserResponseDO userResponseDO = (UserResponseDO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        modelMap.put("user", userResponseDO);
    }
}
