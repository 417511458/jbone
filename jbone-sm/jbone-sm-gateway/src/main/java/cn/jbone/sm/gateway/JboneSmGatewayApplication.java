package cn.jbone.sm.gateway;

import cn.jbone.cas.client.ShiroCasConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class, ShiroCasConfiguration.class})
@EnableFeignClients
@EnableZuulProxy
public class JboneSmGatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JboneSmGatewayApplication.class).banner(new JboneSmGatewayBanner()).logStartupInfo(true).run(args);
    }
}
