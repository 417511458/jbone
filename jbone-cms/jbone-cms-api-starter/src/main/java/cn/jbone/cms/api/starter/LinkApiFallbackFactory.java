package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.LinkApi;
import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 文章API熔断器
 */
public class LinkApiFallbackFactory implements FallbackFactory<LinkApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public LinkApi create(Throwable throwable) {
        return new LinkApi() {
            @Override
            public Result<Void> addOrUpdate(LinkDO linkDO,Integer userId) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id,Integer userId) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> batchDelete(String ids,Integer userId) {
                logger.error("rpc batchDelete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<LinkDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<LinkDO>> getAll(Integer siteId) {
                logger.error("rpc getAll broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
