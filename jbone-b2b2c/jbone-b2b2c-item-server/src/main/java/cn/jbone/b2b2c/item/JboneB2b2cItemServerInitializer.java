package cn.jbone.b2b2c.item;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneB2b2cItemServerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneB2b2cItemServerApplication.class).banner(new JboneB2b2cItemServerBanner()).logStartupInfo(true);
    }
}
