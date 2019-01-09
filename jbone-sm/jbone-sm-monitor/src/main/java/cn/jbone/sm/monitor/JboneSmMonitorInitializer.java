package cn.jbone.sm.monitor;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneSmMonitorInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneSmMonitorApplication.class).banner(new JboneSmMonitorBanner()).logStartupInfo(true);
    }
}
