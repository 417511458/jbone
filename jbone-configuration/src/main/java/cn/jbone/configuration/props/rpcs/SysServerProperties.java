package cn.jbone.configuration.props.rpcs;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysServerProperties implements Serializable {

    /**
     * Spring Cloud Feign调用配置
     */
    private SysServerFeignProperties feign = new SysServerFeignProperties();

}
