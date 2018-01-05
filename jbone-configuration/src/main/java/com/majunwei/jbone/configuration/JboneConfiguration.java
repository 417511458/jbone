package com.majunwei.jbone.configuration;

import com.majunwei.jbone.configuration.sys.SysProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jbone")
public class JboneConfiguration {
    /**
     * 系统管理配置
     */
    private SysProperties sys = new SysProperties();

    public SysProperties getSys() {
        return sys;
    }

    public void setSys(SysProperties sys) {
        this.sys = sys;
    }
}
