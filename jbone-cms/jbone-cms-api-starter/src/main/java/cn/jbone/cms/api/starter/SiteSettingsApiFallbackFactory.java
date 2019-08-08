package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.SiteSettingsApi;
import cn.jbone.cms.common.dataobject.BatchSaveSiteSettingDO;
import cn.jbone.cms.common.dataobject.SiteSettingsDO;
import cn.jbone.cms.common.dataobject.search.SiteSettingsSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 站点设置API熔断器
 */
public class SiteSettingsApiFallbackFactory implements FallbackFactory<SiteSettingsApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public SiteSettingsApi create(Throwable throwable) {
        return new SiteSettingsApi() {
            @Override
            public Result<Void> addOrUpdate(SiteSettingsDO settingsDO, Integer userId) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> batchAddOrUpdate(BatchSaveSiteSettingDO batchSaveSettingDO, Integer userId) {
                logger.error("rpc batchAddOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id, Integer userId) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<SiteSettingsDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<SiteSettingsDO>> getList(Integer siteId) {
                logger.error("rpc getList broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Map<String, String>> getMap(Integer siteId) {
                logger.error("rpc getMap broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PagedResponseDO<SiteSettingsDO>> commonRequest(SiteSettingsSearchDO settingsSearchDO) {
                logger.error("rpc commonRequest broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
