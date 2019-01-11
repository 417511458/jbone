package cn.jbone.sm.zipkinserver;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class JboneSmZipkinServerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneSmZipkinServerApplication.class).banner(new JboneSmZipkinServerBanner()).logStartupInfo(true);
    }
}
