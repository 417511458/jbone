package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.PluginApi;
import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 文章API熔断器
 */
public class PluginApiFallbackFactory implements FallbackFactory<PluginApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public PluginApi create(Throwable throwable) {
        return new PluginApi() {
            @Override
            public Result<Void> addOrUpdate(PluginDO pluginDO,Integer userId) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Integer id,Integer userId) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PluginDO> get(Integer id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<PluginDO>> findByType(String type,Integer siteId) {
                logger.error("rpc findByType broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Map<String, List<PluginDO>>> findAllValidPlugin(Integer siteId) {
                logger.error("rpc findAllValidPlugin broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<PluginDO>> getAll(Integer siteId) {
                logger.error("rpc getAll broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
