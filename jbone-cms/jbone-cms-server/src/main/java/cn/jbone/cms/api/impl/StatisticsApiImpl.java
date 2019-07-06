package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.StatisticsApi;
import cn.jbone.cms.common.dataobject.StatisticsDO;
import cn.jbone.cms.core.service.StatisticsService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsApiImpl implements StatisticsApi {
    @Autowired
    private StatisticsService statisticsService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Result<StatisticsDO> count() {
        StatisticsDO statisticsDO = null;
        try {
            statisticsDO = statisticsService.count();
        } catch (JboneException e) {
            logger.warn("statistics error",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("statistics error",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(statisticsDO);
    }
}
