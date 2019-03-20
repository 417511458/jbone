package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/statistics")
public interface StatisticsApi {

    @RequestMapping(value = "/count",method = {RequestMethod.GET})
    Result<StatisticsDO> count();
}
