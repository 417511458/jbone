package cn.jbone.eb.manager;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneEbManagerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneEbManagerApplication.class).banner(new JboneEbManagerBanner()).logStartupInfo(true);
    }
}
