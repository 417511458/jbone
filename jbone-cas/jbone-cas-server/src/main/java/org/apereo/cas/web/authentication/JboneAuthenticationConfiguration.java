package org.apereo.cas.web.authentication;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.configuration.props.CasProperties;
import cn.jbone.sys.api.UserApi;
import lombok.Generated;
import org.apereo.cas.authentication.AuthenticationEventExecutionPlanConfigurer;
import org.apereo.cas.authentication.AuthenticationHandler;
import org.apereo.cas.authentication.principal.PrincipalFactory;
import org.apereo.cas.authentication.principal.PrincipalFactoryUtils;
import org.apereo.cas.authentication.principal.PrincipalResolver;
import org.apereo.cas.authentication.support.password.PasswordPolicyConfiguration;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.services.ServicesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("jboneAuthenticationConfiguration")
public class JboneAuthenticationConfiguration {
    @Generated
    private static final Logger LOGGER = LoggerFactory.getLogger(JboneAuthenticationConfiguration.class);
    @Autowired
    @Qualifier("defaultPrincipalResolver")
    private ObjectProvider<PrincipalResolver> defaultPrincipalResolver;
    @Autowired
    @Qualifier("servicesManager")
    private ObjectProvider<ServicesManager> servicesManager;
    @Autowired
    private JboneConfiguration jboneConfiguration;

    public JboneAuthenticationConfiguration() {
    }

    @ConditionalOnMissingBean(
            name = {"jbonePrincipalFactory"}
    )
    @Bean
    public PrincipalFactory jbonePrincipalFactory() {
        return PrincipalFactoryUtils.newPrincipalFactory();
    }

    @RefreshScope
    @Bean
    public AuthenticationHandler jboneAuthenticationHandler(UserApi userApi) {
        JboneAuthenticationHandler h = new JboneAuthenticationHandler(null, (ServicesManager)this.servicesManager.getIfAvailable(), this.jbonePrincipalFactory(),null, jboneConfiguration.getCas().getRequiredRole());
        h.setUserApi(userApi);
        return h;
    }

    @ConditionalOnMissingBean(
            name = {"jboneAuthenticationEventExecutionPlanConfigurer"}
    )
    @Bean
    public AuthenticationEventExecutionPlanConfigurer jboneAuthenticationEventExecutionPlanConfigurer(UserApi userApi) {
        return (plan) -> {
                plan.registerAuthenticationHandlerWithPrincipalResolver(this.jboneAuthenticationHandler(userApi), (PrincipalResolver)this.defaultPrincipalResolver.getIfAvailable());
        };
    }

    @ConditionalOnMissingBean(
            name = {"jbonePasswordPolicyConfiguration"}
    )
    @Bean
    public PasswordPolicyConfiguration jbonePasswordPolicyConfiguration() {
        return new PasswordPolicyConfiguration();
    }
}
