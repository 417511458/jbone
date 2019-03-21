package cn.jbone.cms.portal;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneCmsPortalInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneCmsPortalApplication.class).banner(new JboneCmsPortalBanner()).logStartupInfo(true);
    }
}
