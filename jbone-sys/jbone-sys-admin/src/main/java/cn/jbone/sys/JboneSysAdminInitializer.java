package cn.jbone.sys;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneSysAdminInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneSysAdminApplication.class).banner(new JboneSysAdminBanner()).logStartupInfo(true);
    }
}
