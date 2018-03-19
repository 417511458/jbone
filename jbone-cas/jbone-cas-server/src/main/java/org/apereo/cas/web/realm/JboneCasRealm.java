package org.apereo.cas.web.realm;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.api.model.UserInfoModel;
import cn.jbone.sys.api.model.UserModel;
import org.apache.shiro.util.ByteSource;
import org.apereo.cas.web.SpringManager;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.Set;

/**
 * 授权管理
 *
 * @author majunwei
 */
public class JboneCasRealm extends AuthorizingRealm {


    public JboneCasRealm() {
        setName("JboneCasRealm");
    }

    private UserApi getUserApi(){
        ApplicationContext context = SpringManager.getApplicationContext();
        UserApi userApi = context.getBean(UserApi.class);
        return userApi;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        Result<UserInfoModel> userInfoModel = getUserApi().getUserByName(token.getUsername());
        if(userInfoModel == null || !userInfoModel.isSuccess() || userInfoModel.getData() == null){
            throw new AuthenticationException("用户不存在");
        }

        //密码加密，已用户登录名作为salt
//        String newPassword = PasswordUtils.getMd5PasswordWithSalt(new String(userInfoModel.getPassword()),userInfoModel.getUsername());

        ByteSource credentialsSalt = ByteSource.Util.bytes(userInfoModel.getData().getUsername());

        return new SimpleAuthenticationInfo(userInfoModel.getData().getUsername(), userInfoModel.getData().getPassword(),credentialsSalt, getName());
    }


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.fromRealm(getName()).iterator().next();
        Result<UserModel> userModel = getUserApi().getUserDetailByName(userName);
        Set<String> roles = userModel.getData().getRoles();
        Set<String> permissions = userModel.getData().getPermissions();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if(roles != null && !roles.isEmpty()){
            Iterator<String> iterator = roles.iterator();
            while (iterator.hasNext()){
                info.addRole(iterator.next());
            }
        }

        if(permissions != null && !permissions.isEmpty()){
            Iterator<String> iterator = permissions.iterator();
            while (iterator.hasNext()){
                info.addStringPermission(iterator.next());
            }
        }

        return info;
    }
}
