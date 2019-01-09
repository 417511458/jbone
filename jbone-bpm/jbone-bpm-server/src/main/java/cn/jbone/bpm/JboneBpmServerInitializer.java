package cn.jbone.bpm;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneBpmServerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneBpmServerApplication.class).banner(new JboneBpmServerBanner()).logStartupInfo(true);
    }
}
