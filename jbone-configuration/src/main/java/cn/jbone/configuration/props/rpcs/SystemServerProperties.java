package cn.jbone.configuration.props.rpcs;

import lombok.Data;

import java.io.Serializable;

@Data
public class SystemServerProperties implements Serializable {

    /**
     * Spring Cloud Feign调用配置
     */
    private SystemServerFeignProperties feign = new SystemServerFeignProperties();


    @Data
    public static class SystemServerFeignProperties {
        private String protocol = "http";
        private String name = "jbone-system-server";  //系统服务名字
    }

}
