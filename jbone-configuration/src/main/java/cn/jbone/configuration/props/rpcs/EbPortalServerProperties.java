package cn.jbone.configuration.props.rpcs;

import lombok.Data;

import java.io.Serializable;

@Data
public class EbPortalServerProperties implements Serializable {
    private EbPortalServerFeignProperties feign = new EbPortalServerFeignProperties();
}
