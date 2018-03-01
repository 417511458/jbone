package cn.jbone.sys.admin.ui;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafShiroConfiguration {
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
