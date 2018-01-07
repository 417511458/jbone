package org.apereo.cas.web.realm;

import com.majunwei.jbone.sys.api.UserApi;
import com.majunwei.jbone.sys.api.model.UserInfoModel;
import com.majunwei.jbone.sys.api.model.UserModel;
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

import java.util.List;

/**
 * 授权管理
 *
 * @author majunwei
 */
public class JboneCasRealm extends AuthorizingRealm {


    public JboneCasRealm() {
        setName("JboneCasRealm");
    }

    private UserService getUserService(){
        ApplicationContext context = SpringManager.getApplicationContext();
        UserService userService = context.getBean(UserService.class);
        return userService;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UserInfoModel userInfoModel = getUserService().getUserByName(token.getUsername());
        return new SimpleAuthenticationInfo(userInfoModel.getUsername(), userInfoModel.getPassword(), getName());
    }


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.fromRealm(getName()).iterator().next();
        UserModel userModel = getUserService().getUserDetailByName(userName);
        List<String> roles = userModel.getRoles();
        List<String> permissions = userModel.getPermissions();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if(roles != null && !roles.isEmpty()){
            for (int i = 0;i < roles.size();i++){
                info.addRole(roles.get(i));
            }
        }

        if(permissions != null && !permissions.isEmpty()){
            for (int i = 0;i < permissions.size();i++){
                info.addStringPermission(permissions.get(i));
            }
        }

        return info;
    }
}
