package cn.jbone.eb.manager.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController extends CommonController {

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        setCurrentUser(modelMap);
        return "index";
    }

    @RequestMapping("dashboard")
    public String dashboard(ModelMap modelMap){
        return "pages/dashboard";
    }
}
