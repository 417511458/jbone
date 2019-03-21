package cn.jbone.configuration.props.rpcs;

import lombok.Data;

/**
 * 系统服务Feign配置
 */
@Data
public class CmsServerProperties {
    private String protocol = "http";
    private String name = "jbone-cms-server";  //系统服务名字
}
