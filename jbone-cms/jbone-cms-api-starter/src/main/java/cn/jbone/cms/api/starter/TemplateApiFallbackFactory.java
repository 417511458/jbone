package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.TemplateApi;
import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.common.dataobject.search.TemplateSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * 模版API熔断器
 */
public class TemplateApiFallbackFactory implements FallbackFactory<TemplateApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public TemplateApi create(Throwable throwable) {
        return new TemplateApi() {
            @Override
            public Result<Void> addOrUpdate(TemplateDO templateDO,Integer userId) {
                logger.error("rpc addOrUpdate broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> delete(Long id,Integer userId) {
                logger.error("rpc delete broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<TemplateDO> get(Long id) {
                logger.error("rpc get broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PagedResponseDO<TemplateDO>> commonRequest(TemplateSearchDO templateSearchDO) {
                logger.error("rpc getAll broke",throwable);
                return Result.wrapProtectedError();
            }
        };

    }
}
