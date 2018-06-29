package cn.jbone.cas.client.realm;

import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JboneCasRealm extends CasRealm {
    private static final Logger logger = LoggerFactory.getLogger(JboneCasRealm.class);

    private UserApi userApi;
    private String serverName;

    public JboneCasRealm(EhCacheManager ehCacheManager,UserApi userApi,String serverName){
        this.setCacheManager(ehCacheManager);
        this.userApi = userApi;
        this.serverName = serverName;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        CasToken casToken = (CasToken)token;
        if (token == null) {
            return null;
        } else {
            String ticket = (String)casToken.getCredentials();
            if (!StringUtils.hasText(ticket)) {
                return null;
            } else {
                TicketValidator ticketValidator = this.ensureTicketValidator();

                try {
                    Assertion casAssertion = ticketValidator.validate(ticket, this.getCasService());
                    AttributePrincipal casPrincipal = casAssertion.getPrincipal();
                    String userId = casPrincipal.getName();
                    Map<String, Object> attributes = casPrincipal.getAttributes();
                    casToken.setUserId(userId);
                    String rememberMeAttributeName = this.getRememberMeAttributeName();
                    String rememberMeStringValue = (String)attributes.get(rememberMeAttributeName);
                    boolean isRemembered = rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
                    if (isRemembered) {
                        casToken.setRememberMe(true);
                    }

                    /**
                     * 将用户对象保存为身份信息，用于系统获取用户信息
                     */
                    Result<UserInfoResponseDTO> userModel = userApi.getUserDetailByNameAndServerName(userId,serverName);
                    if(!userModel.isSuccess() || userModel.getData() ==null ){
                        throw new JboneException("user is not found.");
                    }

                    List<Object> principals = CollectionUtils.asList(new Object[]{userModel.getData(), attributes});
                    PrincipalCollection principalCollection = new SimplePrincipalCollection(principals, this.getName());
                    return new SimpleAuthenticationInfo(principalCollection, ticket);
                } catch (TicketValidationException var14) {
                    throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", var14);
                }
            }
        }
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

        UserInfoResponseDTO userModel = (UserInfoResponseDTO)super.getAvailablePrincipal(principalCollection);
        Set<String> roles = userModel.getRoles();
        Set<String> permissions = userModel.getPermissions();

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
