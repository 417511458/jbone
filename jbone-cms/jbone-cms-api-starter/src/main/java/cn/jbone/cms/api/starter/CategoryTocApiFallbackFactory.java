package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.CategoryTocApi;
import cn.jbone.cms.common.dataobject.*;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 文章API熔断器
 */
public class CategoryTocApiFallbackFactory implements FallbackFactory<CategoryTocApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public CategoryTocApi create(Throwable throwable) {
        return new CategoryTocApi()
        {
            @Override
            public Result<CategoryTocDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<CategoryTocDO> getByCategoryAndArticle(Long categoryId, Long articleId) {
                logger.error("rpc getByCategoryAndArticle broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<CategoryTocDO> addOrUpdate(CategoryTocDO categoryTocDO) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<CategoryTocDO>> getTree(Long categoryId) {
                logger.error("rpc getTree broke",throwable);
                return Result.wrapProtectedError();
            }
        };
    }
}
