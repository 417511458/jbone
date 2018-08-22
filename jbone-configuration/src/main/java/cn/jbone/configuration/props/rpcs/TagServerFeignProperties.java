package cn.jbone.configuration.props.rpcs;

import lombok.Data;

/**
 * 标签服务Feign配置
 */
@Data
public class TagServerFeignProperties {
    private String protocol = "http";
    private String name = "jbone-tag-server";  //系统服务名字
}
