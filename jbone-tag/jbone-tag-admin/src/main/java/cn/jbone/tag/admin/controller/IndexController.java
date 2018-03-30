package cn.jbone.tag.admin.controller;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sys.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController extends CommonController {

    @Autowired
    private JboneConfiguration jboneConfiguration;

    @Autowired
    private UserApi userApi;

    @RequestMapping("/")
    public String index(ModelMap modelMap){
        setCurrentUser(modelMap,userApi,jboneConfiguration);
        return "index";
    }

    @RequestMapping("dashboard")
    public String dashboard(ModelMap modelMap){
        setCurrentUser(modelMap, userApi, jboneConfiguration);
        return "pages/dashboard";
    }
}
