package com.majunwei.jbone.cas.shiro.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

/**
 * 授权管理
 *
 * @author majunwei
 */
@Component
public class JboneCasRealm extends AuthorizingRealm {

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
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("guest");
            return info;
    }
}
