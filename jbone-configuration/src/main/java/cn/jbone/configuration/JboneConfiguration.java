package cn.jbone.configuration;

import cn.jbone.configuration.props.SsoProperties;
import cn.jbone.configuration.props.FSProperties;
import cn.jbone.configuration.props.RpcProperties;
import cn.jbone.configuration.props.SysProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
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
    private SsoProperties sso = new SsoProperties();

    /**
     * 远程调用配置
     */
    private RpcProperties rpc = new RpcProperties();

    /**
     * 文件系统配置
     */
    @NestedConfigurationProperty
    private FSProperties fs = new FSProperties();


    public SysProperties getSys() {
        return sys;
    }

    public void setSys(SysProperties sys) {
        this.sys = sys;
    }

    public SsoProperties getSso() {
        return sso;
    }

    public void setSso(SsoProperties sso) {
        this.sso = sso;
    }

    public RpcProperties getRpc() {
        return rpc;
    }

    public void setRpc(RpcProperties rpc) {
        this.rpc = rpc;
    }

    public FSProperties getFs() {
        return fs;
    }

    public void setFs(FSProperties fs) {
        this.fs = fs;
    }

    @Override
    public String toString() {
        return "JboneConfiguration{" +
                "sys=" + sys +
                ", sso=" + sso +
                ", rpc=" + rpc +
                '}';
    }

    @PostConstruct
    public void initProperty(){
        logger.info(this.toString());
    }
}
