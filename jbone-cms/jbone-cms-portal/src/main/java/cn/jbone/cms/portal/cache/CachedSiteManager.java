package cn.jbone.cms.portal.cache;

import cn.jbone.cms.api.*;
import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.search.AdvertisementSearchDO;
import cn.jbone.cms.common.dataobject.search.CategorySearchDO;
import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.common.dataobject.PagedResponseDO;
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
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Repository
public class CachedSiteManager implements InitializingBean {
    @Autowired
    private SiteApi siteApi;
    @Autowired
    private SiteSettingsApi siteSettingsApi;
    @Autowired
    private CategoryApi categoryApi;
    @Autowired
    private AdvertisementApi advertisementApi;
    @Autowired
    private PluginApi pluginApi;
    @Autowired
    private LinkApi linkApi;

    private Logger logger = LoggerFactory.getLogger(getClass());

    /** 网站Map */
    private LoadingCache<String, SiteDO> siteMap = null;

    /**
     * 站点属性
     */
    private LoadingCache<String, Map<String,String>> siteSettingsMap = null;

    /**
     * 站点栏目缓存
     */
    private LoadingCache<String, List<CategoryDO>> siteMenusMap = null;

    /**
     * 站点广告
     */
    private LoadingCache<String, List<AdvertisementDO>> siteAdsMap = null;

    /**
     * 站点插件
     */
    private LoadingCache<String, Map<String,List<PluginDO>>> sitePluginMap = null;

    /**
     * 友情链接
     */
    private LoadingCache<String, List<LinkDO>> siteLinksMap = null;

    /**
     * 当前站点，必须在请求pre里设置
     */
    static ThreadLocal<String> domainThreadLocal = new ThreadLocal<>();
    public void checkAndUpdateCurrentSite(HttpServletRequest request){
        String url = request.getScheme()+"://"+ request.getServerName();
        domainThreadLocal.set(url);
    }

    /**
     * 当前站点
     * @return
     */
    public SiteDO getCurrentSite() {
        try {
            return siteMap.get(domainThreadLocal.get());
        } catch (ExecutionException e) {
            logger.error("站点无效",e);
            throw new JboneException("站点无效");
        }
    }

    /**
     * 获取当前网站属性
     * @return
     */
    public Map<String,String> getCurrentSiteSettings(){
        try {
            return siteSettingsMap.get(domainThreadLocal.get());
        } catch (ExecutionException e) {
            logger.error("站点无效",e);
            throw new JboneException("站点无效");
        }
    }

    /**
     * 当前网站ID
     * @return
     */
    public Integer getCurrentSiteId(){
        SiteDO siteDO = getCurrentSite();
        if(siteDO!= null){
            return siteDO.getId();
        }
        return null;
    }

    /**
     * 当前站点广告
     * @return
     */
    public List<AdvertisementDO> getCurrentAds(){
        try {
            return siteAdsMap.get(domainThreadLocal.get());
        } catch (ExecutionException e) {
            logger.error("站点无效",e);
            throw new JboneException("站点无效");
        }
    }

    /**
     * 当前站点栏目
     * @return
     */
    public List<CategoryDO> getCurrentMenus(){
        try {
            return siteMenusMap.get(domainThreadLocal.get());
        } catch (ExecutionException e) {
            logger.error("站点无效",e);
            throw new JboneException("站点无效");
        }
    }

    /**
     * 获取站点插件
     * @param type
     * @return
     */
    public List<PluginDO> getCurrentPlugsByType(String type){
        try {
            return sitePluginMap.get(domainThreadLocal.get()).get(type);
        } catch (ExecutionException e) {
            logger.error("站点无效",e);
            throw new JboneException("站点无效");
        }
    }

    /**
     * 获取站点链接
     * @return
     */
    public List<LinkDO> getCurrentLinks(){
        try {
            return siteLinksMap.get(domainThreadLocal.get());
        } catch (ExecutionException e) {
            logger.error("站点无效",e);
            throw new JboneException("站点无效");
        }
    }

    private Integer cacheSiteMumSize = 100;             //缓存站点最大数,100个域名
    private Integer cacheTimeSecond = 60 * 5;           //缓存失效时间，5m

    private Integer cacheSettingsTimeoutSecond = 60 * 5;    //站点属性超时时间，5m

    private Integer cacheMenusTimeoutSecond = 60 * 10;   //站点栏目超时时间，10m

    private Integer cacheAdsTimeoutSecond = 60 * 10;   //站点栏目超时时间，10m

    private Integer cachePluginTimeoutSecond = 60 * 10; //站点插件超时时间，10m

    private Integer cacheLinkTimeoutSecond = 60 * 10; //站点插件超时时间，10m

    @Override
    public void afterPropertiesSet() throws Exception {
        CachedSiteManager cachedSiteManager = this;
        siteMap = CacheBuilder
                .newBuilder()
                .maximumSize(cacheSiteMumSize)
                .refreshAfterWrite(this.cacheTimeSecond, TimeUnit.SECONDS)
                .build(new CacheLoader<String, SiteDO>() {
                            public SiteDO load(String key) throws Exception {
                                return cachedSiteManager.reloadSite(key);
                            }
                        });

        siteSettingsMap = CacheBuilder
                .newBuilder()
                .maximumSize(cacheSiteMumSize)
                .refreshAfterWrite(this.cacheSettingsTimeoutSecond, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Map<String,String>>() {
                    public Map<String,String> load(String key) throws Exception {
                        return cachedSiteManager.reloadSiteSettings(key);
                    }
                });

        siteMenusMap = CacheBuilder
                .newBuilder()
                .maximumSize(cacheSiteMumSize)
                .refreshAfterWrite(this.cacheMenusTimeoutSecond, TimeUnit.SECONDS)
                .build(new CacheLoader<String, List<CategoryDO>>() {
                    public List<CategoryDO> load(String key) throws Exception {
                        return cachedSiteManager.reloadMenus(key);
                    }
                });

        siteAdsMap = CacheBuilder
                .newBuilder()
                .maximumSize(cacheSiteMumSize)
                .refreshAfterWrite(this.cacheAdsTimeoutSecond, TimeUnit.SECONDS)
                .build(new CacheLoader<String, List<AdvertisementDO>>() {
                    public List<AdvertisementDO> load(String key) throws Exception {
                        return cachedSiteManager.reloadAds(key);
                    }
                });

        sitePluginMap = CacheBuilder
                .newBuilder()
                .maximumSize(cacheSiteMumSize)
                .refreshAfterWrite(this.cachePluginTimeoutSecond, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Map<String,List<PluginDO>>>() {
                    public Map<String,List<PluginDO>> load(String key) throws Exception {
                        return cachedSiteManager.reloadPlugins(key);
                    }
                });

        siteLinksMap = CacheBuilder
                .newBuilder()
                .maximumSize(cacheSiteMumSize)
                .refreshAfterWrite(this.cacheLinkTimeoutSecond, TimeUnit.SECONDS)
                .build(new CacheLoader<String, List<LinkDO>>() {
                    public List<LinkDO> load(String key) throws Exception {
                        return cachedSiteManager.reloadLinks(key);
                    }
                });
    }

    /**
     * 获取链接
     * @param key
     * @return
     */
    public List<LinkDO> reloadLinks(String key){
        try {
            Result<List<LinkDO>> result = linkApi.getAll(siteMap.get(key).getId());
            if(result != null && result.isSuccess()){
                return result.getData();
            }
        } catch (ExecutionException e) {
            logger.error("站点无效:{}",key,e);
            throw new JboneException("站点无效");
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * 加载站点插件
     * @param key
     * @return
     */
    public Map<String,List<PluginDO>> reloadPlugins(String key){
        try {
            Result<Map<String,List<PluginDO>>> result = pluginApi.findAllValidPlugin(siteMap.get(key).getId());
            if(result != null && result.isSuccess() && !CollectionUtils.isEmpty(result.getData())){
                return result.getData();
            }
        } catch (ExecutionException e) {
            logger.error("站点无效:{}",key,e);
            throw new JboneException("站点无效");
        }
        return Collections.EMPTY_MAP;
    }
    /**
     * 加载站点广告
     * @param key
     * @return
     */
    public List<AdvertisementDO> reloadAds(String key){
        try {
            AdvertisementSearchDO advertisementSearchDO = new AdvertisementSearchDO().enable();
            advertisementSearchDO.setSiteId(siteMap.get(key).getId());
            advertisementSearchDO.setPageSize(100);
            Result<PagedResponseDO<AdvertisementDO>> pagedResponseDO = advertisementApi.commonRequest(advertisementSearchDO);
            if(pagedResponseDO != null && pagedResponseDO.isSuccess() && pagedResponseDO.getData() != null && !CollectionUtils.isEmpty(pagedResponseDO.getData().getDatas())){
                return pagedResponseDO.getData().getDatas();
            }
        } catch (ExecutionException e) {
            logger.error("站点无效:{}",key,e);
            throw new JboneException("站点无效");
        }
        return Collections.EMPTY_LIST;
    }

    /**
     * 加载站点栏目
     * @param key
     * @return
     */
    public List<CategoryDO> reloadMenus(String key){
        try {
            CategorySearchDO categorySearchDO = new CategorySearchDO();
            categorySearchDO.setInMenu(BooleanEnum.TRUE);
            categorySearchDO.setStatus(StatusEnum.PUBLISH);
            categorySearchDO.setSiteId(siteMap.get(key).getId());
            Result<List<CategoryDO>> result = categoryApi.requestCategorysTree(categorySearchDO);
            if(result != null && result.isSuccess() && !CollectionUtils.isEmpty(result.getData())){
                return result.getData();
            }
        } catch (ExecutionException e) {
            logger.error("站点无效:{}",key,e);
            throw new JboneException("站点无效");
        }

        return Collections.EMPTY_LIST;
    }


    /**
     * 加载站点属性
     * @param key
     * @return
     */
    public Map<String,String> reloadSiteSettings(String key){
        try {
            Result<Map<String, String>> settingMap =  siteSettingsApi.getMap(siteMap.get(key).getId());
            if(settingMap.isSuccess()){
                if(!CollectionUtils.isEmpty(settingMap.getData())){
                    return settingMap.getData();
                }
            }
        } catch (ExecutionException e) {
            logger.error("站点无效:{}",key,e);
            throw new JboneException("站点无效");
        }
        return new HashMap<>();
    }

    /**
     * 加载站点
     * @param key
     * @return
     */
    public SiteDO reloadSite(String key){
        Result<SiteDO> siteDOResult = siteApi.getByDomain(key);
        if(siteDOResult != null && siteDOResult.isSuccess()){
            return siteDOResult.getData();
        }
        logger.error("站点无效:{}",key);
        throw new JboneException("站点无效");
    }
}
