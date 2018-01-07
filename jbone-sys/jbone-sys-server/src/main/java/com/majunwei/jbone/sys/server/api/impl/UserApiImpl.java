package com.majunwei.jbone.sys.server.api.impl;

import com.majunwei.jbone.sys.api.UserApi;
import com.majunwei.jbone.sys.api.model.UserInfoModel;
import com.majunwei.jbone.sys.api.model.UserModel;
import com.majunwei.jbone.sys.dao.domain.RbacUserEntity;
import com.majunwei.jbone.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserApiImpl implements UserApi {

    private Logger logger = LoggerFactory.getLogger(UserApiImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public UserInfoModel getUserByName(String username) {
        RbacUserEntity userEntity = userService.findByUserName(username);
        UserInfoModel userInfoModel = new UserInfoModel();
        BeanUtils.copyProperties(userEntity,userInfoModel);
        logger.info("username : {}" , username);
        return userInfoModel;
    }
    @Override
    public UserModel getUserDetailByName(String username){
        return null;
    }
}
