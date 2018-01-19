package com.majunwei.jbone.sys.admin.controller;

import com.majunwei.jbone.cas.client.utils.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(ModelMap modelMap){
        //modelMap.put("user", SessionUtil.getCurrentUser());
        return "index";
    }
}
