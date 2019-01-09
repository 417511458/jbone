package cn.jbone.sys;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneSysServerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneSysServerApplication.class).banner(new JboneSysServerBanner()).logStartupInfo(true);
    }
}
