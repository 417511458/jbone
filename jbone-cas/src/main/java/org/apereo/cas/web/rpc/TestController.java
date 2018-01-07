package org.apereo.cas.web.rpc;

import org.apereo.cas.web.rpc.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    UserService userService;
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println(userService);
       return "test";
    }
}
