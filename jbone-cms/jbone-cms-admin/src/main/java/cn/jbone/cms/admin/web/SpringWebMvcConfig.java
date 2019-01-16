package cn.jbone.cms.admin.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringWebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();

        registration.setFilter(new RewriteFilter());//注册rewrite过滤器

        registration.addUrlPatterns("/*");

        registration.addInitParameter(RewriteFilter.REWRITE_TO,"/");

        registration.addInitParameter(RewriteFilter.REWRITE_PATTERNS, "/ui/*");

        registration.setName("rewriteFilter");

        registration.setOrder(1);

        return registration;

    }
}
