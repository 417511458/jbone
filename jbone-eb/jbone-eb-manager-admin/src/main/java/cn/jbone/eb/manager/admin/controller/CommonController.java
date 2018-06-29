package cn.jbone.eb.manager.admin.controller;

import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.ModelMap;

public class CommonController {

    public void setCurrentUser(ModelMap modelMap){
        UserInfoResponseDTO currentUser = (UserInfoResponseDTO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        modelMap.put("user", currentUser);
    }
}
