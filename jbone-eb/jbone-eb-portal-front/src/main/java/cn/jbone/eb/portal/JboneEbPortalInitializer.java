package cn.jbone.eb.portal;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneEbPortalInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneEbPortalApplication.class).banner(new JboneEbPortalBanner()).logStartupInfo(true);
    }
}
