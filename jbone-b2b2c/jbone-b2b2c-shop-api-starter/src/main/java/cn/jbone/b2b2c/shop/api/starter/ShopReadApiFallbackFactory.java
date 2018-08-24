package cn.jbone.b2b2c.shop.api.starter;

import cn.jbone.b2b2c.shop.api.ShopReadApi;
import cn.jbone.b2b2c.shop.api.dto.response.ShopDetailsRespDTO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 店铺API熔断器
 */
public class ShopReadApiFallbackFactory implements FallbackFactory<ShopReadApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ShopReadApi create(Throwable throwable) {

        return new ShopReadApi() {

            @Override
            public Result<ShopDetailsRespDTO> getShopDetails(Long shopId) {
                logger.warn("getShopDetails broke with {}",shopId);
                return Result.wrapProtectedError();
            }
        };
    }
}
