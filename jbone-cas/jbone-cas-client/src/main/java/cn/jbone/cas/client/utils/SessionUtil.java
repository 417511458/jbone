package cn.jbone.cas.client.utils;

import cn.jbone.sys.common.UserResponseDO;
import org.apache.shiro.SecurityUtils;

/**
 * 会话工具类，获取当前用户
 */
public class SessionUtil {
    public static UserResponseDO getCurrentUser(){
        return (UserResponseDO)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
    }
}
