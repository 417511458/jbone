package org.apereo.cas.web.realm;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.common.UserRequestDO;
import cn.jbone.sys.common.UserResponseDO;
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

    /**
     * 验证登录
     * @param authcToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UserRequestDO userRequestDO = UserRequestDO.buildSecurity(token.getUsername());
        Result<UserResponseDO> result = getUserApi().commonRequest(userRequestDO);

        checkResult(result);

        ByteSource credentialsSalt = ByteSource.Util.bytes(result.getData().getSecurityInfo().getSalt());

        return new SimpleAuthenticationInfo(result.getData().getBaseInfo().getUsername(), result.getData().getSecurityInfo().getPassword(),credentialsSalt, getName());
    }

    private void checkResult(Result<UserResponseDO> result){
        if(result == null || !result.isSuccess() || result.getData() == null){
            throw new AuthenticationException("用户不存在");
        }
    }

    /**
     * 获取登录用户权限信息
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.fromRealm(getName()).iterator().next();
        UserRequestDO userRequestDO = UserRequestDO.buildAll(userName,null);
        Result<UserResponseDO> result = getUserApi().commonRequest(userRequestDO);

        checkResult(result);

        UserResponseDO userResponseDO = result.getData();

        Set<String> roles = userResponseDO.getAuthInfo().getRoles();
        Set<String> permissions = userResponseDO.getAuthInfo().getPermissions();
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
