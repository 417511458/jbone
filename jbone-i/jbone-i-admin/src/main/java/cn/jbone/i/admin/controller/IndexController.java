package cn.jbone.i.admin.controller;

import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(ModelMap modelMap){
        UserInfoResponseDTO currentUser = (UserInfoResponseDTO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        modelMap.put("user", currentUser);
        return "index";
    }

}
