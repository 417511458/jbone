package com.majunwei.jbone.sys.admin.controller;

import com.majunwei.jbone.configuration.JboneConfiguration;
import com.majunwei.jbone.sys.api.UserApi;
import com.majunwei.jbone.sys.api.model.UserModel;
import com.majunwei.jbone.sys.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends CommonController {
    @Autowired
    JboneConfiguration jboneConfiguration;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        setCurrentUser(userService,modelMap,jboneConfiguration);
        return "index";
    }
}
