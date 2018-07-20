package cn.jbone.sm.monitor.publisher;

import com.netflix.hystrix.HystrixCollapserKey;
import com.netflix.hystrix.HystrixCollapserMetrics;
import com.netflix.hystrix.HystrixCollapserProperties;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherCollapser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JboneHystrixMetricsPublisherCollapser implements HystrixMetricsPublisherCollapser {
    private HystrixCollapserKey collapserKey;
    private HystrixCollapserMetrics metrics;
    private HystrixCollapserProperties properties;

    private Logger logger = LoggerFactory.getLogger(JboneHystrixMetricsPublisherCollapser.class);

    public JboneHystrixMetricsPublisherCollapser(HystrixCollapserKey collapserKey, HystrixCollapserMetrics metrics, HystrixCollapserProperties properties){
        this.collapserKey = collapserKey;
        this.metrics = metrics;
        this.properties = properties;
    }

    @Override
    public void initialize() {
        logger.info("JboneHystrixMetricsPublisherCollapser initialize start");
        logger.info("collapserKey: {}",collapserKey);
        logger.info("metrics: {}",metrics);
        logger.info("properties: {}",properties);
        logger.info("JboneHystrixMetricsPublisherCollapser initialize end.");
    }
}
