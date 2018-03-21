package cn.jbone.tag;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 1:01
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class JboneTagServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JboneTagServerApplication.class).banner(new JboneTagServerBanner()).logStartupInfo(true).run(args);
    }
}
