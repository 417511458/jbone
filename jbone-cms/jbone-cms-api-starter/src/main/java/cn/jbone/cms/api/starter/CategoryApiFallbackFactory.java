package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.CategoryApi;
import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.search.CategorySearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 栏目API熔断器
 */
public class CategoryApiFallbackFactory implements FallbackFactory<CategoryApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public CategoryApi create(Throwable throwable) {

        return new CategoryApi() {
            @Override
            public Result<Void> addOrUpdate(CategoryDO categoryDO,Integer userId) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id,Integer userId) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<CategoryDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<CategoryDO>> getCategoryTree(Integer siteId) {
                logger.error("rpc getCategoryTree broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<CategoryDO>> requestCategorysTree(CategorySearchDO categorySearchDO) {
                logger.error("rpc requestCategorysTree broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PagedResponseDO<CategoryDO>> requestCategorys(CategorySearchDO categorySearchDO) {
                logger.error("rpc requestCategorys broke",throwable);
                return Result.wrapProtectedError();
            }


        };

    }
}
