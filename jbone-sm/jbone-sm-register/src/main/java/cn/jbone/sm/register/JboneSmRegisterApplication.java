package cn.jbone.sm.register;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动类
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@EnableEurekaServer
public class JboneSmRegisterApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JboneSmRegisterApplication.class)
                .banner(new JboneSmRegisterBanner())
                .logStartupInfo(true)
                .run(args);
    }
}
