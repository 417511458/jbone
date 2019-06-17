package cn.jbone.configuration.props;

import lombok.Data;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
public class FSProperties {

    /**
     * 七牛云配置
     */
    @NestedConfigurationProperty
    private QiniuProperties qiniu = new QiniuProperties();

    /**
     * fastdfs配置
     */
    @NestedConfigurationProperty
    private FastDfsProperties fastDfs = new FastDfsProperties();

    @Data
    public static class QiniuProperties{
        private String accessKey;   //AK
        private String secretKey;   //SK
        private String bucket;      //存储区域
        private String domain;      //返回的域名
    }

    @Data
    public static class FastDfsProperties{

    }
}
