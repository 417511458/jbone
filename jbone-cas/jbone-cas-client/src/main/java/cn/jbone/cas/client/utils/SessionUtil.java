package cn.jbone.cas.client.utils;

import cn.jbone.sys.common.UserResponseDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 会话工具类，获取当前用户
 */
public class SessionUtil {
    public static UserResponseDO getCurrentUser(){
        Subject subject = SecurityUtils.getSubject();
        if(subject != null && subject.getPrincipals() != null){
            return (UserResponseDO)subject.getPrincipals().getPrimaryPrincipal();
        }
        return null;
    }
}
