package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.TemplateApi;
import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * 文章API熔断器
 */
public class TemplateApiFallbackFactory implements FallbackFactory<TemplateApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public TemplateApi create(Throwable throwable) {
        return new TemplateApi() {
            @Override
            public Result<Void> addOrUpdate(TemplateDO templateDO) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<TemplateDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<TemplateDO>> getAll() {
                logger.error("rpc getAll broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
