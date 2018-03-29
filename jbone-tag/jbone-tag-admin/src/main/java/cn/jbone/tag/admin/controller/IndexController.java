package cn.jbone.tag.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController extends CommonController {

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        setCurrentUser(modelMap);
        return "index";
    }

    @RequestMapping("dashboard")
    public String dashboard(ModelMap modelMap){
        setCurrentUser(modelMap);
        return "pages/dashboard";
    }
}
