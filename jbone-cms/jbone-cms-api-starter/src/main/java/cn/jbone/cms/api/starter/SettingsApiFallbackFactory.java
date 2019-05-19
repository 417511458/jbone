package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.SettingsApi;
import cn.jbone.cms.common.dataobject.BatchSaveSettingDO;
import cn.jbone.cms.common.dataobject.SettingsDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 文章API熔断器
 */
public class SettingsApiFallbackFactory implements FallbackFactory<SettingsApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public SettingsApi create(Throwable throwable) {
        return new SettingsApi() {
            @Override
            public Result<Void> batchAddOrUpdate(BatchSaveSettingDO batchSaveSettingDO) {
                logger.error("rpc batchAddOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> addOrUpdate(SettingsDO settingsDO) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> batchDelete(String ids) {
                logger.error("rpc batchDelete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<SettingsDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<SettingsDO>> getList() {
                logger.error("rpc getList broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Map<String, String>> getMap() {
                logger.error("rpc getMap broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
