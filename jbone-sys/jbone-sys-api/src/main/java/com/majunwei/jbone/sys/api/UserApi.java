package com.majunwei.jbone.sys.api;

import com.majunwei.jbone.sys.api.model.UserInfoModel;
import com.majunwei.jbone.sys.api.model.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
public interface UserApi {
    @RequestMapping("/getUserByName")
    UserInfoModel getUserByName(@RequestParam("name") String username);

    @RequestMapping("/getUserDetail")
    UserModel getUserDetailByName(@RequestParam("name") String username);
}
