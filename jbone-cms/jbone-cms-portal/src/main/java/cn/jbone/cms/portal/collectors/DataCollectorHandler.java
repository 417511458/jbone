package cn.jbone.cms.portal.collectors;

import cn.jbone.cms.common.constant.GlobalConstant;
import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.portal.cache.CachedDataManager;
import cn.jbone.cms.portal.cache.CachedSiteManager;
import cn.jbone.common.exception.JboneException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Service
public class DataCollectorHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CachedSiteManager cachedSiteManager;

    @Autowired
    Map<String,IDataCollector> dataCollectorMap;

    @Autowired
    private CachedDataManager cachedDataManager;

    ExecutorService executorService =  new ThreadPoolExecutor(10, 200,60L, TimeUnit.SECONDS,new LinkedBlockingDeque<Runnable>(100));

    public void handle(DataCollectorContext context){

        if(StringUtils.isBlank(context.getPage())){
            throw new JboneException("页面不能为空");
        }

        context.setSiteId(cachedSiteManager.getCurrentSiteId());

        TemplateDO templateDO = cachedSiteManager.getCurrentSite().getTemplate();
        if(templateDO == null){
            //取默认模版
            templateDO = cachedDataManager.getTemplate(GlobalConstant.DEFAULT_TEMPLATE_CODE);
        }

        if(templateDO == null){
            throw new JboneException("没有找到站点[" + context.getSiteId() + "]的模版");
        }

        if(StringUtils.isBlank(templateDO.getDataCollectors())){
            logger.warn("'没找到模版[{}]的数据收集器",templateDO.getId());
            return;
        }

        JSONObject dataCollectorObj = JSON.parseObject(templateDO.getDataCollectors());
        String pageDataCollectors = dataCollectorObj.getString(context.getPage());
        logger.info("当前站点：{}, 当前页：{},收集数据：{}",context.getSiteId(),context.getPage(),pageDataCollectors);

        if(StringUtils.isBlank(pageDataCollectors)){
            return;
        }



        String[] dataCollectors = pageDataCollectors.split(",");
        if(dataCollectors.length == 1){
            //单线程处理
            IDataCollector dataCollector = dataCollectorMap.get(dataCollectors[0]);
            if(dataCollector == null){
                logger.error("没找到数据收集器:{}",dataCollectors[0]);
            }else{
                dataCollector.collect(context);
            }
        }else{
            //多线程处理
            List<Future<Void>> futureList = new ArrayList<>();
            for (String collectorName : dataCollectors){
                IDataCollector dataCollector = dataCollectorMap.get(collectorName);
                if(dataCollector == null){
                    logger.error("没找到数据收集器:{}",collectorName);
                    continue;
                }
                futureList.add(executorService.submit(new Callable<Void>() {
                    @Override
                    public Void call() throws Exception {
                        dataCollector.collect(context);
                        return null;
                    }
                }));
            }

            if(!CollectionUtils.isEmpty(futureList)){
                for (Future<Void> future : futureList) {
                    try {
                        future.get(1000l,TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        logger.error("等待数据收集执行失败",e);
                    }
                }
            }

        }

    }
}
