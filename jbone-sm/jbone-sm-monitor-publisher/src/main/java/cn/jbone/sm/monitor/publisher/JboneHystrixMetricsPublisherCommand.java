package cn.jbone.sm.monitor.publisher;

import com.netflix.hystrix.*;
import com.netflix.hystrix.strategy.metrics.HystrixMetricsPublisherCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * hystrixCommand监控发布器，用于监控HystrixCommand的接口
 */
public class JboneHystrixMetricsPublisherCommand implements HystrixMetricsPublisherCommand {

    private HystrixCommandKey commandKey;
    private HystrixCommandGroupKey commandGroupKey;
    private HystrixCommandMetrics metrics;
    private HystrixCircuitBreaker circuitBreaker;
    private HystrixCommandProperties properties;

    private Logger logger = LoggerFactory.getLogger(JboneHystrixMetricsPublisherCommand.class);

    public JboneHystrixMetricsPublisherCommand(HystrixCommandKey commandKey, HystrixCommandGroupKey commandGroupKey, HystrixCommandMetrics metrics, HystrixCircuitBreaker circuitBreaker, HystrixCommandProperties properties){
        this.commandKey = commandKey;
        this.commandGroupKey = commandGroupKey;
        this.metrics = metrics;
        this.circuitBreaker = circuitBreaker;
        this.properties = properties;
    }

    @Override
    public void initialize() {
        logger.info("JboneHystrixMetricsPublisherCommand initialize start");
        logger.info("commandKey: {}",commandKey);
        logger.info("commandGroupKey: {}",commandGroupKey);
        logger.info("metrics: {}",metrics.getHealthCounts());
        logger.info("circuitBreaker: {}",circuitBreaker.isOpen());
        logger.info("properties: {}",properties);
        logger.info("JboneHystrixMetricsPublisherCommand initialize end.");
    }
}
