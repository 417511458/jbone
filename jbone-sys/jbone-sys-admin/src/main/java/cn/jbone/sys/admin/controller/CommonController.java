package cn.jbone.sys.admin.controller;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import cn.jbone.sys.core.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.ModelMap;

public class CommonController {

    public void setCurrentUser(UserService userService, ModelMap modelMap, JboneConfiguration jboneConfiguration){
        UserInfoResponseDTO currentUser = (UserInfoResponseDTO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        UserInfoResponseDTO userModel = userService.getUserDetailByNameAndServerName(currentUser.getUsername(),jboneConfiguration.getSys().getServerName());
        modelMap.put("user", userModel);
    }
}
