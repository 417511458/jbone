package com.majunwei.jbone.sys.api;

import com.majunwei.jbone.sys.api.model.UserInfoModel;
import com.majunwei.jbone.sys.api.model.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
public interface UserApi {
    @RequestMapping(value = "/getUserByName")
    UserInfoModel getUserByName(@RequestParam("username") String username);

    @RequestMapping(value = "/getUserDetail")
    UserModel getUserDetailByName(@RequestParam("username") String username);

    @RequestMapping(value = "/getUserDetailByNameAndServerName")
    UserModel getUserDetailByNameAndServerName(@RequestParam("username") String username,@RequestParam("serverName") String serverName);
}
