package cn.jbone.bpm.admin.ui;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/21 22:54
 */
@Configuration
public class ThymeleafShiroConfiguration {

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
