package com.majunwei.jbone.cas.shiro.realm;

import com.majunwei.jbone.sys.api.UserApi;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.subject.WebSubject;
import org.apereo.cas.web.SpringManager;
import org.apereo.cas.web.rpc.sys.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 授权管理
 *
 * @author majunwei
 */
@Component
public class JboneCasRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    public JboneCasRealm(){
        setName("JboneCasRealm");
//        setCredentialsMatcher();
        //setCredentialsMatcher(new Sha256CredentialsMatcher());
    }
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
            return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
    }


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ApplicationContext context = SpringManager.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        UserService us = context.getBean(UserService.class);
        UserApi userApi = context.getBean(UserApi.class);
        String userName = (String) principals.fromRealm(getName()).iterator().next();
        us.getUserByName(userName);
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("guest");
            return info;
    }
}
