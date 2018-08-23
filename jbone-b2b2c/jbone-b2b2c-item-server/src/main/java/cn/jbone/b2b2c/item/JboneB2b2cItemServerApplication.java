package cn.jbone.b2b2c.item;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class JboneB2b2cItemServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JboneB2b2cItemServerApplication.class).banner(new JboneB2b2cItemServerBanner()).run(args);
    }
}
