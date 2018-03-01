package cn.jbone.configuration;

import cn.jbone.configuration.sys.AuthProperties;
import cn.jbone.configuration.sys.CasProperties;
import cn.jbone.configuration.sys.SysProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * 所有配置的入口
 */
@Configuration
@ConfigurationProperties(prefix = "jbone")
public class JboneConfiguration {
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 系统管理配置
     */
    private SysProperties sys = new SysProperties();

    /**
     * CAS配置
     */
    private CasProperties cas = new CasProperties();

    /**
     * 授权服务
     */
    private AuthProperties auth = new AuthProperties();


    public SysProperties getSys() {
        return sys;
    }

    public void setSys(SysProperties sys) {
        this.sys = sys;
    }

    public CasProperties getCas() {
        return cas;
    }

    public void setCas(CasProperties cas) {
        this.cas = cas;
    }

    public AuthProperties getAuth() {
        return auth;
    }

    public void setAuth(AuthProperties auth) {
        this.auth = auth;
    }

    @Override
    public String toString() {
        return "JboneConfiguration{" +
                "sys=" + sys +
                ", cas=" + cas +
                ", auth=" + auth +
                '}';
    }

    @PostConstruct
    public void initProperty(){
        logger.info(this.toString());
    }
}
