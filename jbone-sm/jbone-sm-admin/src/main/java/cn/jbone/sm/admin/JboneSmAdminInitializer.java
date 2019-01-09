package cn.jbone.sm.admin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneSmAdminInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneSmAdminApplication.class).banner(new JboneSmAdminBanner()).logStartupInfo(true);
    }
}
