package com.majunwei.jbone.sys.admin.controller;

import com.majunwei.jbone.configuration.JboneConfiguration;
import com.majunwei.jbone.sys.api.model.UserModel;
import com.majunwei.jbone.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.ModelMap;

public class CommonController {

    public void setCurrentUser(UserService userService, ModelMap modelMap, JboneConfiguration jboneConfiguration){
        UserModel currentUser = (UserModel) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        UserModel userModel = userService.getUserDetailByNameAndServerName(currentUser.getUsername(),jboneConfiguration.getSys().getServerName());
        modelMap.put("user", userModel);
    }
}
