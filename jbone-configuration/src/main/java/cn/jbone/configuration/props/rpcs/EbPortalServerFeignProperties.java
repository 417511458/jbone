package cn.jbone.configuration.props.rpcs;

import lombok.Data;

@Data
public class EbPortalServerFeignProperties {
    private String protocol = "http";
    private String name = "eb-portal-server";  //系统服务名字
}
