package cn.jbone.tag;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/21 22:23
 */
public class JboneTagAdminInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JboneTagAdminApplication.class).banner(new JboneTagAdminBanner()).logStartupInfo(true);
    }
}
