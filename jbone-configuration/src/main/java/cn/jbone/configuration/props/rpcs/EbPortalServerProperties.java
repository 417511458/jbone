package cn.jbone.configuration.props.rpcs;

import java.io.Serializable;

public class EbPortalServerProperties implements Serializable {
    private EbPortalServerFeignProperties feign = new EbPortalServerFeignProperties();

    public EbPortalServerFeignProperties getFeign() {
        return feign;
    }

    public void setFeign(EbPortalServerFeignProperties feign) {
        this.feign = feign;
    }

    @Override
    public String toString() {
        return "EbPortalServerProperties{" +
                "feign=" + feign +
                '}';
    }
}
