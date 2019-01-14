package cn.jbone.b2b2c.item.api.starter;

import cn.jbone.b2b2c.item.api.ItemReadApi;
import cn.jbone.b2b2c.item.api.request.GetItemTopListReqDTO;
import cn.jbone.b2b2c.item.api.response.ItemBaseInfoRespDTO;
import cn.jbone.b2b2c.item.api.response.ItemDetailRespDTO;
import cn.jbone.common.rpc.Result;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * API熔断器
 */
public class ItemReadApiFallbackFactory implements FallbackFactory<ItemReadApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ItemReadApi create(Throwable throwable) {

        return new ItemReadApi() {

            @Override
            public Result<List<ItemBaseInfoRespDTO>> getItemTopList(GetItemTopListReqDTO getItemTopListReqDTO) {
                logger.warn("getItemTopList broke with {}",getItemTopListReqDTO);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<ItemDetailRespDTO> getItemDetail(long itemId) {
                logger.warn("getItemDetail broke with {}",itemId);
                return Result.wrapProtectedError();
            }

        };
    }
}
