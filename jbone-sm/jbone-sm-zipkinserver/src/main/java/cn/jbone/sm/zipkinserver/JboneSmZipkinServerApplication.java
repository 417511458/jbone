package cn.jbone.sm.zipkinserver;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import zipkin2.server.internal.EnableZipkinServer;

@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
@EnableZipkinServer
public class JboneSmZipkinServerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(JboneSmZipkinServerApplication.class).banner(new JboneSmZipkinServerBanner()).logStartupInfo(true).run(args);
    }
}
