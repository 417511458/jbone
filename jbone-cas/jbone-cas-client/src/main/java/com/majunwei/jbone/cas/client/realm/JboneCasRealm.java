package com.majunwei.jbone.cas.client.realm;

import com.majunwei.jbone.sys.api.UserApi;
import com.majunwei.jbone.sys.api.model.UserModel;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JboneCasRealm extends CasRealm {
    private static final Logger logger = LoggerFactory.getLogger(JboneCasRealm.class);

    private UserApi userApi;


    public JboneCasRealm(EhCacheManager ehCacheManager,UserApi userApi){
        this.setCacheManager(ehCacheManager);
        this.userApi = userApi;
    }



    /**
     * 权限认证，为当前登录的Subject授予角色和权限
     *  ：本例中该方法的调用时机为需授权资源被访问时
     *  ：并且每次访问需授权资源时都会执行该方法中的逻辑，这表明本例中默认并未启用AuthorizationCache
     *  ：如果连续访问同一个URL（比如刷新），该方法不会被重复调用，Shiro有一个时间间隔（也就是cache时间，在ehcache-shiro.xml中配置），超过这个时间间隔再刷新页面，该方法会被执行
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("##################加载Shiro权限认证##################");

        String loginName = (String)super.getAvailablePrincipal(principalCollection);
        UserModel userModel = userApi.getUserDetailByName(loginName);
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
