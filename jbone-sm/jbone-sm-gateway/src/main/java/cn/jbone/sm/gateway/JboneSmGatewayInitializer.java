package cn.jbone.sm.gateway;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneSmGatewayInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneSmGatewayApplication.class).banner(new JboneSmGatewayBanner()).logStartupInfo(true);
    }
}
