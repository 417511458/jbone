package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.AdvertisementApi;
import cn.jbone.cms.common.dataobject.AdvertisementDO;
import cn.jbone.cms.common.dataobject.search.AdvertisementSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 广告API熔断器
 */
public class AdvertisementApiFallbackFactory implements FallbackFactory<AdvertisementApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public AdvertisementApi create(Throwable throwable) {
        return new AdvertisementApi() {
            @Override
            public Result<Void> addOrUpdate(AdvertisementDO advertisementDO,Integer userId) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id,Integer userId) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<AdvertisementDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PagedResponseDO<AdvertisementDO>> commonRequest(AdvertisementSearchDO advertisementSearchDO) {
                logger.error("rpc commonRequest broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Map<String, List<AdvertisementDO>>> findAllMap() {
                logger.error("rpc findAllMap broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
