package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.ArticleApi;
import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.dataobject.ArticleRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文章API熔断器
 */
public class ArticleApiFallbackFactory implements FallbackFactory<ArticleApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ArticleApi create(Throwable throwable) {

        return new ArticleApi() {
            @Override
            public Result<ArticleResponseDO> addOrUpdate(ArticleRequestDO articleRequestDO,Integer userId) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id, Integer uid) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> flushDelete(Long id,Integer userId) {
                logger.error("rpc flushDelete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<ArticleResponseDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> hits(Long id) {
                logger.error("rpc hits broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PagedResponseDO<ArticleResponseDO>> commonRequest(ArticleSearchDO articleSearchDO) {
                logger.error("rpc commonRequest broke",throwable);
                return Result.wrapProtectedError();
            }
        };
    }
}
