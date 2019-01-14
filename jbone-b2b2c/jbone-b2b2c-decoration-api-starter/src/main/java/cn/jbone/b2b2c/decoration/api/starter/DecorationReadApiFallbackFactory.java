package cn.jbone.b2b2c.decoration.api.starter;

import cn.jbone.b2b2c.decoration.api.DecorationReadApi;
import cn.jbone.b2b2c.decoration.api.dto.response.ShopDecorationInfoRespDTO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * API熔断器
 */
public class DecorationReadApiFallbackFactory implements FallbackFactory<DecorationReadApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public DecorationReadApi create(Throwable throwable) {

        return new DecorationReadApi() {
            @Override
            public Result<ShopDecorationInfoRespDTO> getShopDecorationInfo(long shopId) {
                logger.warn("getShopDecorationInfo broke with {}",shopId);
                return Result.wrapProtectedError();
            }
        };
    }
}
