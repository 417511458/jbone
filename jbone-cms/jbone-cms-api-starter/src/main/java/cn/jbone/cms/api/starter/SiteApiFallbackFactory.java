package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.SiteApi;
import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.cms.common.dataobject.search.SiteSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * 文章API熔断器
 */
public class SiteApiFallbackFactory implements FallbackFactory<SiteApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public SiteApi create(Throwable throwable) {
        return new SiteApi() {
            @Override
            public Result<SiteDO> getByDomain(String domain) {
                logger.error("rpc getByDomain broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<SiteDO> getById(Integer id) {
                logger.error("rpc getById broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<SiteDO>> getByUserId(Integer userId) {
                logger.error("rpc getByUserId broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Integer id) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> addOrUpdate(SiteDO siteDO) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PagedResponseDO<SiteDO>> commonRequest(SiteSearchDO siteSearchDO) {
                logger.error("rpc commonRequest broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
