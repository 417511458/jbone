package com.majunwei.jbone.sys.server.api.impl;

import com.majunwei.jbone.sys.api.UserApi;
import com.majunwei.jbone.sys.api.model.UserModel;
import com.majunwei.jbone.sys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserApiImpl implements UserApi {

    private Logger logger = LoggerFactory.getLogger(UserApiImpl.class);

    @Autowired
    private UserService userService;

    @Override
    public UserModel getUserByName(String username) {
        logger.info("username : {}" , username);
        return null;
    }
}
