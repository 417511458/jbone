package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.CommentApi;
import cn.jbone.cms.api.LinkApi;
import cn.jbone.cms.common.dataobject.CommentDO;
import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 评论API熔断器
 */
public class CommentApiFallbackFactory implements FallbackFactory<CommentApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public CommentApi create(Throwable throwable) {
        return new CommentApi() {
            @Override
            public Result<Void> addOrUpdate(CommentDO commentDO) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<CommentDO>> getByArticleId(Long articleId) {
                logger.error("rpc getByArticleId broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
