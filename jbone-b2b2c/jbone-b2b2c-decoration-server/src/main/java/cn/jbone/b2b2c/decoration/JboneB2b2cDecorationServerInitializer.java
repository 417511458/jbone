package cn.jbone.b2b2c.decoration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneB2b2cDecorationServerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneB2b2cDecorationServerApplication.class).banner(new JboneB2b2cDecorationServerBanner()).logStartupInfo(true);
    }
}
