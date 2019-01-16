package cn.jbone.cms;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneCmsAdminInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneCmsAdminApplication.class).banner(new JboneCmsAdminBanner()).logStartupInfo(true);
    }
}
