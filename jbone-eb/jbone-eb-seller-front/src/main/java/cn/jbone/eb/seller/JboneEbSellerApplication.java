package cn.jbone.eb.seller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class JboneEbSellerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JboneEbSellerApplication.class).banner(new JboneEbSellerBanner()).run(args);
    }
}
