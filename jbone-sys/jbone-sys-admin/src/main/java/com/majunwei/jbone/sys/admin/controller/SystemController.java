package com.majunwei.jbone.sys.admin.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system")
public class SystemController {

    @RequiresRoles("admin")
    @RequestMapping("/index")
    public String index(){
        return "system/index";
    }
}
