package org.apereo.cas.pswd.config;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.pswd.action.ChangePasswordAction;
import org.apereo.cas.pswd.action.InitChangePasswordAction;
import org.apereo.cas.web.flow.actions.CasDefaultFlowUrlHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.webflow.config.FlowDefinitionRegistryBuilder;
import org.springframework.webflow.config.FlowExecutorBuilder;
import org.springframework.webflow.context.servlet.FlowUrlHandler;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.servlet.FlowHandler;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

@Configuration
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class ChangePasswordConfiguration {

    public static String FLOW_ID_CHANGEPASSWORD = "changePassword";
    private static final String BASE_CLASSPATH_WEBFLOW = "classpath*:/webflow";

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private FlowBuilderServices flowBuilderServices;

    @Autowired
    private CasConfigurationProperties casProperties;

    @Bean
    public FlowUrlHandler changePasswordFlowUrlHandler() {
        return new CasDefaultFlowUrlHandler();
    }

    /**
     * 用于判定执行更改密码流程，调用webflow执行器
     * @return
     */
    @Bean
    public HandlerAdapter changePasswordHandlerAdapter() {
        final FlowHandlerAdapter handler = new FlowHandlerAdapter() {
            @Override
            public boolean supports(final Object handler) {
                return super.supports(handler) && ((FlowHandler) handler)
                        .getFlowId().equals(FLOW_ID_CHANGEPASSWORD);
            }
        };
        handler.setFlowExecutor(changePasswordFlowExecutor());
        handler.setFlowUrlHandler(changePasswordFlowUrlHandler());
        return handler;
    }


    /**
     * 作为DispatchServlet和webflow的桥梁，调用Adapter
     * @return
     */
    @Bean
    public HandlerMapping changePasswordFlowHandlerMapping() {
        final FlowHandlerMapping handler = new FlowHandlerMapping();
        handler.setOrder(5);
        handler.setFlowRegistry(changePasswordFlowRegistry());
        return handler;
    }

    /**
     * Webflow注册器，用于加载注册修改密码的flow
     * @return
     */
    @Bean
    public FlowDefinitionRegistry changePasswordFlowRegistry() {
        final FlowDefinitionRegistryBuilder builder = new FlowDefinitionRegistryBuilder(this.applicationContext, flowBuilderServices);
        builder.setBasePath(BASE_CLASSPATH_WEBFLOW);
        builder.addFlowLocationPattern("/changePassword/*-webflow.xml");
        return builder.build();
    }

    /**
     * 修改密码执行器,流程的真正执行者
     * @return
     */
    @RefreshScope
    @Bean
    public FlowExecutor changePasswordFlowExecutor() {
        final FlowExecutorBuilder builder = new FlowExecutorBuilder(changePasswordFlowRegistry(), this.applicationContext);
        builder.setAlwaysRedirectOnPause(casProperties.getWebflow().isAlwaysPauseRedirect());
        builder.setRedirectInSameState(casProperties.getWebflow().isRedirectSameState());
        return builder.build();
    }


    @Bean
    public InitChangePasswordAction initChangePasswordAction(){
        return new InitChangePasswordAction();
    }

    @Bean
    public ChangePasswordAction changePasswordAction(){return new ChangePasswordAction();}
}
