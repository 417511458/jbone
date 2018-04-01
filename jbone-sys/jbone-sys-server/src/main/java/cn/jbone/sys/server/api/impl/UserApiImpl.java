package cn.jbone.sys.server.api.impl;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.api.model.UserInfoModel;
import cn.jbone.sys.api.model.UserModel;
import cn.jbone.sys.core.service.UserService;
import cn.jbone.sys.core.service.model.user.UserBaseInfoModel;
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
    public Result<UserInfoModel> getUserByName(String username) {
        UserInfoModel userInfoModel = null;
        try {
            UserBaseInfoModel userEntity = userService.findByUserName(username);

            if(userEntity == null){
                return Result.wrap404Error("user is not found");
            }

            userInfoModel = new UserInfoModel();

            BeanUtils.copyProperties(userEntity,userInfoModel);

        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return new Result<UserInfoModel>(userInfoModel);
    }

    @RequestMapping("/getUserDetail")
    public Result<UserModel> getUserDetailByName(String username){
        UserModel userModel = null;
        try {
            userModel = userService.getUserDetailByNameAndServerName(username,null);
            if(userModel == null){
                return Result.wrap404Error("user is not found");
            }
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }

        return new Result<UserModel>(userModel);
    }


    @RequestMapping("/getUserDetailByNameAndServerName")
    public Result<UserModel> getUserDetailByNameAndServerName(String username, String serverName) {
        UserModel userModel = null;
        try {
            userModel = userService.getUserDetailByNameAndServerName(username,serverName);
            if(userModel == null){
                return Result.wrap404Error("user is not found");
            }
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return new Result<UserModel>(userModel);
    }
}
