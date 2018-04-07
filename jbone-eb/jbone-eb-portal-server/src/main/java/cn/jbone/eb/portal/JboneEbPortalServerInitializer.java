package cn.jbone.eb.portal;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneEbPortalServerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneEbPortalServerApplication.class).banner(new JboneEbPortalServerBanner()).logStartupInfo(true);
    }
}
