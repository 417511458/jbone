package cn.jbone.b2b2c.item.api.starter;

import cn.jbone.b2b2c.item.api.ItemCategoryReadApi;
import cn.jbone.b2b2c.item.api.response.ItemCategoryTreeRespDTO;
import cn.jbone.b2b2c.item.api.response.ShopCagetoryItemsRespDTO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * API熔断器
 */
public class ItemCategoryReadApiFallbackFactory implements FallbackFactory<ItemCategoryReadApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ItemCategoryReadApi create(Throwable throwable) {

        return new ItemCategoryReadApi() {

            @Override
            public Result<List<ItemCategoryTreeRespDTO>> getItemCategoryTree(long shopId) {
                logger.warn("getItemCategoryTree broke with {}",shopId);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<ShopCagetoryItemsRespDTO>> getShopCategoryItems(long shopId) {
                logger.warn("getShopCategoryItems broke with {}",shopId);
                return Result.wrapProtectedError();
            }
        };
    }
}
