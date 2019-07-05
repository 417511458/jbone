package cn.jbone.cms.portal.manager;

import cn.jbone.cms.api.SiteApi;
import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Repository
public class SiteManager implements InitializingBean {
    @Autowired
    private SiteApi siteApi;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /* 网站Map */
    private LoadingCache<String, SiteDO> siteMap = null;

    ThreadLocal<String> domainThreadLocal = new ThreadLocal<>();
    public void checkAndUpdateCurrentSite(HttpServletRequest request){
        String url = request.getScheme()+"://"+ request.getServerName();
        domainThreadLocal.set(url);
    }

    public SiteDO getCurrentSite() {
        try {
            return siteMap.get(domainThreadLocal.get());
        } catch (ExecutionException e) {
            throw new JboneException("站点无效");
        }
    }

    public Integer getCurrentSiteId(){
        SiteDO siteDO = getCurrentSite();
        if(siteDO!= null){
            return siteDO.getId();
        }
        return null;
    }

    private Integer cacheMumSize = 100;         //缓存最大数,100个域名
    private Integer cacheTimeSecond = 1200;      //缓存失效时间，2小时

    @Override
    public void afterPropertiesSet() throws Exception {
        SiteManager siteManager = this;
        siteMap = CacheBuilder
                .newBuilder()
                .maximumSize(cacheMumSize)
                .refreshAfterWrite(this.cacheTimeSecond, TimeUnit.SECONDS)
                .build(new CacheLoader<String, SiteDO>() {
                            public SiteDO load(String key) throws Exception {
                                return siteManager.reloadSite(key);
                            }
                        });
    }

    public SiteDO reloadSite(String key){
        Result<SiteDO> siteDOResult = siteApi.getByDomain(key);
        if(siteDOResult != null && siteDOResult.isSuccess()){
            return siteDOResult.getData();
        }
        throw new JboneException("站点无效");
    }
}
