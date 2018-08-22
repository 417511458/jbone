package cn.jbone.b2b2c.shop;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneB2b2cShopServerInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneB2b2cShopServerApplication.class).banner(new JboneB2b2cShopServerBanner()).logStartupInfo(true);
    }
}
