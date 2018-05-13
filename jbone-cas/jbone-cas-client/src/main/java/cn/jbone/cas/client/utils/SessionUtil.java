package cn.jbone.cas.client.utils;

import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import org.apache.shiro.SecurityUtils;

/**
 * 会话工具类，获取当前用户
 */
public class SessionUtil {
    public static UserInfoResponseDTO getCurrentUser(){
        return (UserInfoResponseDTO)SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
    }
}
