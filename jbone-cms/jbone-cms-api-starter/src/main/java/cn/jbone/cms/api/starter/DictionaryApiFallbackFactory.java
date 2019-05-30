package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.DictionaryApi;
import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.DictionaryGroupDO;
import cn.jbone.cms.common.dataobject.search.DictionaryGroupSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 文章API熔断器
 */
public class DictionaryApiFallbackFactory implements FallbackFactory<DictionaryApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public DictionaryApi create(Throwable throwable) {

        return new DictionaryApi() {
            @Override
            public Result<Void> addOrUpdateGroup(DictionaryGroupDO dictionaryGroupDO) {
                logger.error("rpc addOrUpdateGroup broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> deleteGroup(Integer id) {
                logger.error("rpc deleteGroup broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<DictionaryGroupDO> getGroup(Integer id) {
                logger.error("rpc getGroup broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<PagedResponseDO<DictionaryGroupDO>> requestGroup(DictionaryGroupSearchDO dictionaryGroupSearchDO) {
                logger.error("rpc requestGroup broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> addOrUpdateItem(DictionaryItemDO dictionaryItemDO) {
                logger.error("rpc addOrUpdateItem broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> deleteItem(Integer id) {
                logger.error("rpc deleteItem broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<DictionaryItemDO> getItem(Integer id) {
                logger.error("rpc getItem broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<DictionaryItemDO>> getItems(Integer groupId) {
                logger.error("rpc getItems broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<DictionaryItemDO>> getItemsByCode(String code) {
                logger.error("rpc getItemsByCode broke",throwable);
                return Result.wrapProtectedError();
            }
        };
    }
}
