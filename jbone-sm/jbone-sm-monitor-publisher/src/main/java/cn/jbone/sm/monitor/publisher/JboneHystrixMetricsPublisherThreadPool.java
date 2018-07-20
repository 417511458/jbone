package cn.jbone.sm.monitor.publisher;

import com.netflix.hystrix.HystrixThreadPoolKey;
import com.netflix.hystrix.HystrixThreadPoolMetrics;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 线程池发布器
 */
public class JboneHystrixMetricsPublisherThreadPool implements HystrixMetricsPublisherThreadPool {

    private HystrixThreadPoolKey threadPoolKey;
    private HystrixThreadPoolMetrics metric;
    private HystrixThreadPoolProperties properties;

    private Logger logger = LoggerFactory.getLogger(JboneHystrixMetricsPublisherThreadPool.class);

    public JboneHystrixMetricsPublisherThreadPool(HystrixThreadPoolKey threadPoolKey, HystrixThreadPoolMetrics metrics, HystrixThreadPoolProperties properties){
        this.threadPoolKey = threadPoolKey;
        this.metric = metrics;
        this.properties = properties;
    }

    @Override
    public void initialize() {
        logger.info("JboneHystrixMetricsPublisherThreadPool initialize start");
        logger.info("threadPoolKey: {}",threadPoolKey);
        logger.info("metric.getCurrentActiveCount(): {}",metric.getCurrentActiveCount());
        logger.info("metric.getCurrentCompletedTaskCount(): {}",metric.getCurrentCompletedTaskCount());
        logger.info("metric.getCurrentCorePoolSize(): {}",metric.getCurrentCorePoolSize());
        logger.info("metric.getCurrentLargestPoolSize(): {}",metric.getCurrentLargestPoolSize());
        logger.info("metric.getCurrentMaximumPoolSize(): {}",metric.getCurrentMaximumPoolSize());
        logger.info("properties: {}",properties);
        logger.info("JboneHystrixMetricsPublisherThreadPool initialize end.");
    }
}
