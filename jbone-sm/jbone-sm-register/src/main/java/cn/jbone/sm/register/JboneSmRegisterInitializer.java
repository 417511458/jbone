package cn.jbone.sm.register;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneSmRegisterInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder
                .sources(JboneSmRegisterApplication.class)
                .banner(new JboneSmRegisterBanner())
                .logStartupInfo(true);
    }
}
