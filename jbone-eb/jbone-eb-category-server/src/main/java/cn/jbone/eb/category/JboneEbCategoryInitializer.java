package cn.jbone.eb.category;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

public class JboneEbCategoryInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneEbCategoryApplication.class).banner(new JboneEbCategoryBanner()).logStartupInfo(true);
    }
}
