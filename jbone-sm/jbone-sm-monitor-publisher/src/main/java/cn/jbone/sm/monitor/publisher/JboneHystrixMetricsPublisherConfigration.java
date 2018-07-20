package cn.jbone.sm.monitor.publisher;

import com.netflix.hystrix.strategy.HystrixPlugins;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 指标发布器配置类，用于初始化发布器
 */
@Configuration
public class JboneHystrixMetricsPublisherConfigration {
    @Bean
    public JboneHystrixMetricsPublisher getJboneHystrixMetricsPublisher(){
        JboneHystrixMetricsPublisher publisher = new JboneHystrixMetricsPublisher();
        HystrixPlugins.getInstance().registerMetricsPublisher(publisher);
        return publisher;
    }
}
