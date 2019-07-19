package cn.jbone.cms.portal.cache;

import cn.jbone.cms.api.TemplateApi;
import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.common.dataobject.search.TemplateSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Repository
public class CachedDataManager implements InitializingBean {

    /** 网站Map */
    private LoadingCache<String, TemplateDO> templateMap = null;

    @Autowired
    private TemplateApi templateApi;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void afterPropertiesSet() throws Exception {
        CachedDataManager cachedDataManager = this;
        templateMap = CacheBuilder
                .newBuilder()
                .maximumSize(1)
                .refreshAfterWrite(60, TimeUnit.MINUTES)
                .build(new CacheLoader<String, TemplateDO>() {
                    public TemplateDO load(String key) throws Exception {
                        return cachedDataManager.reloadTemplate(key);
                    }
                });
    }

    public TemplateDO getTemplate(String code){
        try {
            return this.templateMap.get(code);
        } catch (ExecutionException e) {
            logger.error("查询模版失败{}",code,e);
            return null;
        }
    }

    public TemplateDO reloadTemplate(String code){
        TemplateSearchDO templateSearchDO = new TemplateSearchDO();
        templateSearchDO.setCode(code);
        templateSearchDO.setPageSize(1);
        Result<PagedResponseDO<TemplateDO>> responseDOResult = templateApi.commonRequest(templateSearchDO);
        if(responseDOResult != null && responseDOResult.isSuccess() && !CollectionUtils.isEmpty(responseDOResult.getData().getDatas())){
             return responseDOResult.getData().getDatas().get(0);
        }
        return null;
    }
}
