package com.majunwei.jbone.cas.shiro.config;

import com.majunwei.jbone.cas.shiro.listener.JboneCasSessionListener;
import com.majunwei.jbone.cas.shiro.realm.JboneCasRealm;
import com.majunwei.jbone.cas.shiro.session.JboneCasSessionDao;
import com.majunwei.jbone.cas.shiro.session.JboneCasSessionFactory;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置
 *
 * 1、SecurityManager配置      ---  管理所有
 * 2、SessionManager配置       ---  管理会话
 * 3、SessionDAO配置           ---  持久化会话
 * 4、Realm配置                ---  登录授权
 * 5、CacheManager配置         ---  缓存管理
 * 6、ShiroFilter配置          ---  过滤规则
 * 7、AOP配置                  ---  切入
 *
 * @author majunwei
 */
@Configuration
@ConfigurationProperties(prefix = "shiro")
public class ShiroConfiguration {

    private long sessionTimeOut = 1000 * 60 * 3;

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(JboneCasRealm jboneCasRealm, DefaultWebSessionManager sessionManager, CookieRememberMeManager rememberMeManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(jboneCasRealm);
        securityManager.setSessionManager(sessionManager);
        securityManager.setRememberMeManager(rememberMeManager);
        return securityManager;
    }

    @Bean(name = "sessionManager")
    public DefaultWebSessionManager getDefaultWebSessionManager(@Qualifier("sessionIdCookie") SimpleCookie simpleCookie, JboneCasSessionListener sessionListener, JboneCasSessionDao sessionDao, JboneCasSessionFactory sessionFactory){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(sessionTimeOut);
        sessionManager.setSessionIdCookie(simpleCookie);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionValidationSchedulerEnabled(false);
        sessionManager.setSessionListeners(Arrays.asList(sessionListener));
        sessionManager.setSessionDAO(sessionDao);
        sessionManager.setSessionFactory(sessionFactory);
        return sessionManager;
    }

    @Bean(name = "sessionIdCookie")
    public SimpleCookie getSessionIdCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setMaxAge(-1);
        simpleCookie.setHttpOnly(true);
        simpleCookie.setName("SESSION_SESSID");
        return simpleCookie;
    }

    @Bean(name = "rememberMeCookie")
    public SimpleCookie getRememberMeCookie(){
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setMaxAge(2592000);
        simpleCookie.setHttpOnly(true);
        simpleCookie.setName("REMEMBER_SESSID");
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager getRememberMeManager(@Qualifier("rememberMeCookie") SimpleCookie simpleCookie){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(simpleCookie);
        rememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
        return rememberMeManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }


    /**
     * 权限相关配置过滤规则
     *
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 设置登陆页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/");

        //权限控制
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("/plugins/**","anon");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/**","user");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public FilterRegistrationBean delegatingFilterProxy(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistrationBean.setFilter(proxy);
        return filterRegistrationBean;
    }

    public long getSessionTimeOut() {
        return sessionTimeOut;
    }

    public void setSessionTimeOut(long sessionTimeOut) {
        this.sessionTimeOut = sessionTimeOut;
    }
}
