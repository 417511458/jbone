package cn.jbone.sys.admin.controller;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sys.core.service.UserService;
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

    @RequestMapping("dashboard")
    public String dashboard(ModelMap modelMap){
        setCurrentUser(userService,modelMap,jboneConfiguration);
        return "pages/dashboard";
    }
}
