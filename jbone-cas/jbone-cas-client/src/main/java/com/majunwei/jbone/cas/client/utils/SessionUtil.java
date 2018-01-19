package com.majunwei.jbone.cas.client.utils;

import com.majunwei.jbone.sys.api.model.UserModel;
import org.apache.shiro.SecurityUtils;

/**
 * 会话工具类，获取当前用户
 */
public class SessionUtil {
    public static UserModel getCurrentUser(){
        return (UserModel)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
    }
}
