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
        private String connectTimeoutInSeconds;     //连接tracker服务器超时时长
        private String networkTimeoutInSeconds;     //socket连接超时时长
        private String charset;                     //编码
        private String httpAntiStealToken;          //是否开启http安全TOken
        private String httpSecretKey;               //开启安全token的密钥
        private String httpTrackerHttpPort;         //tracker服务器端口
        private String trackerServers;              //tracker服务器列表，IP:port,IP:port

        private String domain;      //返回的域名
    }
}
