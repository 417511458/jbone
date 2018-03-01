package cn.jbone.cas.client;

import cn.jbone.cas.client.listener.JboneCasSessionListener;
import cn.jbone.cas.client.realm.JboneCasRealm;
import cn.jbone.cas.client.session.JboneCasSessionDao;
import cn.jbone.cas.client.session.JboneCasSessionFactory;
import cn.jbone.cas.client.filter.JboneLogoutFilter;
import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sys.api.UserApi;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro集成Cas配置
 *
 */
@Configuration
public class ShiroCasConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(ShiroCasConfiguration.class);


    @Bean
    public JboneCasRealm getJboneCasRealm(EhCacheManager ehCacheManager, UserApi userApi, JboneConfiguration jboneConfiguration){
        JboneCasRealm realm = new JboneCasRealm(ehCacheManager,userApi,jboneConfiguration.getSys().getServerName());
        realm.setCasServerUrlPrefix(jboneConfiguration.getCas().getCasServerUrl());
        realm.setCasService(jboneConfiguration.getCas().getCurrentServerUrlPrefix() + jboneConfiguration.getCas().getCasFilterUrlPattern());
        return realm;
    }

    @Bean
    public EhCacheManager getEhCacheManager() {
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }

    /**
     * 注册DelegatingFilterProxy（Shiro）
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        //  该值缺省为false,表示生命周期由SpringApplicationContext管理,设置为true则表示由ServletContainer管理
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }

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
    public DefaultWebSecurityManager getDefaultWebSecurityManager(JboneCasRealm jboneCasRealm,DefaultWebSessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(jboneCasRealm);
        //用户授权/认证信息Cache, 采用EhCache 缓存
        securityManager.setCacheManager(getEhCacheManager());
        securityManager.setSubjectFactory(new CasSubjectFactory());
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

    @Bean(name = "sessionManager")
    public DefaultWebSessionManager getDefaultWebSessionManager(SessionListener sessionListener, SessionDAO sessionDao, SessionFactory sessionFactory,JboneConfiguration jboneConfiguration){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(jboneConfiguration.getCas().getClientSessionTimeout());
        sessionManager.setSessionValidationSchedulerEnabled(false);
        sessionManager.setSessionListeners(Arrays.asList(sessionListener));
        sessionManager.setSessionDAO(sessionDao);
        sessionManager.setSessionFactory(sessionFactory);
        return sessionManager;
    }

    @Bean(name = "sessionDao")
    public SessionDAO getSessionDao(StringRedisTemplate redisTemplate){
        JboneCasSessionDao sessionDao = new JboneCasSessionDao(redisTemplate);

        return sessionDao;
    }

    @Bean(name = "sessionListener")
    public SessionListener getSessionListener(){
        return new JboneCasSessionListener();
    }

    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(){
        return new JboneCasSessionFactory();
    }



    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 加载shiroFilter权限控制规则
     */
    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean,JboneConfiguration jboneConfiguration){
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

        filterChainDefinitionMap.put(jboneConfiguration.getCas().getCasFilterUrlPattern(), "casLogout,casFilter");// shiro集成cas后，首先添加该规则
        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/casLogout","casLogout");
        //添加jbone.cas的配置规则
        if(jboneConfiguration.getCas().getFilterChainDefinition() != null){
            filterChainDefinitionMap.putAll(jboneConfiguration.getCas().getFilterChainDefinition());
        }
        String common = filterChainDefinitionMap.get("/**");

        filterChainDefinitionMap.put("/**","casLogout" + (StringUtils.isNotBlank(common) ? ("," + common) : ""));
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }

    /**
     * CAS过滤器
     */
    @Bean(name = "casFilter")
    public CasFilter getCasFilter(JboneConfiguration jboneConfiguration) {
        CasFilter casFilter = new CasFilter();
        casFilter.setName("casFilter");
        casFilter.setEnabled(true);
        //失败后跳转到CAS登录页面
        casFilter.setFailureUrl(jboneConfiguration.getCas().getEncodedLoginUrl()); // 我们选择认证失败后再打开登录页面
        return casFilter;
    }

    /**
     * ShiroFilter
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager, CasFilter casFilter,JboneConfiguration jboneConfiguration,StringRedisTemplate redisTemplate,DefaultWebSessionManager sessionManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // SecurityManager，Shiro安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // Shiro登录页面，这里默认为CAS的登录页面：jbone-cas.majunwei.com/login?service=serviceurl
        shiroFilterFactoryBean.setLoginUrl(jboneConfiguration.getCas().getEncodedLoginUrl());

        shiroFilterFactoryBean.setSuccessUrl(jboneConfiguration.getCas().getSuccessUrl());
        shiroFilterFactoryBean.setUnauthorizedUrl(jboneConfiguration.getCas().getUnauthorizedUrl());
        // 添加casFilter到shiroFilter中
        Map<String, Filter> filters = new HashMap<>();
        filters.put("casFilter", casFilter);

        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setRedirectUrl(jboneConfiguration.getCas().getEncodedLogoutUrl());
        filters.put("logout",logoutFilter);
        // 注销
        JboneLogoutFilter jboneLogoutFilter = new JboneLogoutFilter(redisTemplate);
        jboneLogoutFilter.setSessionManager(sessionManager);
        filters.put("casLogout",jboneLogoutFilter);

        shiroFilterFactoryBean.setFilters(filters);

        loadShiroFilterChain(shiroFilterFactoryBean,jboneConfiguration);
        return shiroFilterFactoryBean;
    }

}