package cn.jbone.eb.consumer;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneEbConsumerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneEbConsumerApplication.class).banner(new JboneEbConsumerBanner()).logStartupInfo(true);
    }
}
