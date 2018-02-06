package com.majunwei.jbone.sys.server.api.impl;

import com.majunwei.jbone.sys.api.UserApi;
import com.majunwei.jbone.sys.api.model.UserInfoModel;
import com.majunwei.jbone.sys.api.model.UserModel;
import com.majunwei.jbone.sys.service.UserService;
import com.majunwei.jbone.sys.service.model.user.UserBaseInfoModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiImpl implements UserApi {

    private Logger logger = LoggerFactory.getLogger(UserApiImpl.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserByName")
    public UserInfoModel getUserByName(String username) {
        UserBaseInfoModel userEntity = userService.findByUserName(username);
        if(userEntity == null){
            return null;
        }
        UserInfoModel userInfoModel = new UserInfoModel();
        BeanUtils.copyProperties(userEntity,userInfoModel);
        logger.info("username : {}" , username);
        return userInfoModel;
    }
    @RequestMapping("/getUserDetail")
    public UserModel getUserDetailByName(String username){
        return userService.getUserDetailByNameAndServerName(username,null);
    }


    @RequestMapping("/getUserDetailByNameAndServerName")
    public UserModel getUserDetailByNameAndServerName(String username, String serverName) {
        return userService.getUserDetailByNameAndServerName(username,serverName);
    }
}
