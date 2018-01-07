package org.apereo.cas.web.realm;

import com.majunwei.jbone.sys.api.UserApi;
import com.majunwei.jbone.sys.api.model.UserInfoModel;
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

/**
 * 授权管理
 *
 * @author majunwei
 */
public class JboneCasRealm extends AuthorizingRealm {


    public JboneCasRealm() {
        setName("JboneCasRealm");
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        ApplicationContext context = SpringManager.getApplicationContext();
        UserService userService = context.getBean(UserService.class);
        UserInfoModel userInfoModel = userService.getUserByName(token.getUsername());
        return new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
    }


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ApplicationContext context = SpringManager.getApplicationContext();
        UserService userService = context.getBean(UserService.class);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("guest");
        return info;
    }
}
