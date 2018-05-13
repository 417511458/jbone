package cn.jbone.bpm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class JboneBpmServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JboneBpmServerApplication.class).banner(new JboneBpmServerBanner()).run(args);
    }
}
