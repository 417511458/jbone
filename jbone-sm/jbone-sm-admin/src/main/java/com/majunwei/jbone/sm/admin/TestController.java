package com.majunwei.jbone.sm.admin;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("test")
    @RequiresRoles("serverAdministrator")
    public String test(){
        return "test";
    }

    @RequestMapping("test2")
    @RequiresRoles("serverAdministrator")
    public String test2(){
        return "test2";
    }
}
