package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.TagApi;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.cms.common.dataobject.search.TagSearchDO;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * 文章API熔断器
 */
public class TagApiFallbackFactory implements FallbackFactory<TagApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public TagApi create(Throwable throwable) {
        return new TagApi() {
            @Override
            public Result<List<TagDO>> getAll() {
                logger.error("rpc getAll broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<TagDO>> findTagCloud() {
                logger.error("rpc findTagCloud broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<TagDO>> getByName(String name) {
                logger.error("rpc getByName broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<TagDO> getById(Long id) {
                logger.error("rpc getById broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> addOrUpdate(TagDO tagDO) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PagedResponseDO<TagDO>> commonRequest(TagSearchDO tagSearchDO) {
                logger.error("rpc commonRequest broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
