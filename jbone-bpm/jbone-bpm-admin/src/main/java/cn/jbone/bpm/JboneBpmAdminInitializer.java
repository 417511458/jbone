package cn.jbone.bpm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneBpmAdminInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneBpmAdminApplication.class).banner(new JboneBpmAdminBanner()).logStartupInfo(true);
    }
}
