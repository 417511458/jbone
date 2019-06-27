package cn.jbone.fs.repo.fastdfs;

import cn.jbone.configuration.JboneConfiguration;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

public class FastdfsConfiguration {

    @Autowired
    private JboneConfiguration jboneConfiguration;

    @Bean
    public StorageClient1 getTrackerClient() throws Exception{
        Properties properties = new Properties();
        properties.put(ClientGlobal.PROP_KEY_HTTP_SECRET_KEY,jboneConfiguration.getFs().getFastDfs().getHttpSecretKey());
        properties.put(ClientGlobal.PROP_KEY_CHARSET,jboneConfiguration.getFs().getFastDfs().getCharset());
        properties.put(ClientGlobal.PROP_KEY_CONNECT_TIMEOUT_IN_SECONDS,jboneConfiguration.getFs().getFastDfs().getConnectTimeoutInSeconds());
        properties.put(ClientGlobal.PROP_KEY_HTTP_ANTI_STEAL_TOKEN,jboneConfiguration.getFs().getFastDfs().getHttpAntiStealToken());
        properties.put(ClientGlobal.PROP_KEY_HTTP_TRACKER_HTTP_PORT,jboneConfiguration.getFs().getFastDfs().getHttpTrackerHttpPort());
        properties.put(ClientGlobal.PROP_KEY_NETWORK_TIMEOUT_IN_SECONDS,jboneConfiguration.getFs().getFastDfs().getNetworkTimeoutInSeconds());
        properties.put(ClientGlobal.PROP_KEY_TRACKER_SERVERS,jboneConfiguration.getFs().getFastDfs().getTrackerServers());
        ClientGlobal.initByProperties(properties);
        TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
        TrackerServer trackerServer = trackerClient.getConnection();
        if (trackerServer == null) {
            throw new IllegalStateException("getConnection return null");
        }
        //给dfs发送一个消息,解决第一次上传报recv package size -1!=10
        ProtoCommon.activeTest(trackerServer.getSocket());

        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        if (storageServer == null) {
            throw new IllegalStateException("getStoreStorage return null");
        }
        return new StorageClient1(trackerServer,storageServer);
    }
}
