package cn.jbone.configuration.props.rpcs;

import java.io.Serializable;

public class SysServerProperties implements Serializable {

    /**
     * Spring Cloud Feign调用配置
     */
    private SysServerFeignProperties feign = new SysServerFeignProperties();

    public SysServerFeignProperties getFeign() {
        return feign;
    }

    public void setFeign(SysServerFeignProperties feign) {
        this.feign = feign;
    }

    @Override
    public String toString() {
        return "SysServerProperties{" +
                "feign=" + feign +
                '}';
    }
}
