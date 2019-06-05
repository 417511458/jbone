package cn.jbone.cms.portal;

import cn.jbone.cms.portal.intercepter.CommonInterceptor;
import cn.jbone.cms.portal.ui.JboneDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private CommonInterceptor commonInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(commonInterceptor);
    }

//    @Bean
//    public JboneDialect jboneDialect(){
//        return new JboneDialect();
//    }

}
