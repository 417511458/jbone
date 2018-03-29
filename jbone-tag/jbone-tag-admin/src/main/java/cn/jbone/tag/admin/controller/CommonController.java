package cn.jbone.tag.admin.controller;

import cn.jbone.sys.api.model.UserModel;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.ModelMap;

public class CommonController {

    public void setCurrentUser(ModelMap modelMap){
        UserModel currentUser = (UserModel) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        modelMap.put("user", currentUser);
    }
}
