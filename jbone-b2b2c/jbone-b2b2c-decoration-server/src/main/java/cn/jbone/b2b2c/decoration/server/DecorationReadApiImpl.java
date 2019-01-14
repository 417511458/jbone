package cn.jbone.b2b2c.decoration.server;

import cn.jbone.b2b2c.decoration.api.DecorationReadApi;
import cn.jbone.b2b2c.decoration.api.dto.response.ShopDecorationInfoRespDTO;
import cn.jbone.b2b2c.decoration.core.ShopDecorationService;
import cn.jbone.common.rpc.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DecorationReadApiImpl implements DecorationReadApi {

    Logger logger = LoggerFactory.getLogger(DecorationReadApiImpl.class);

    @Autowired
    private ShopDecorationService shopDecorationService;
    /**
     * 获取店铺装修信息
     * @return 商品排行榜
     */
    @HystrixCommand(commandKey = "getShopDecorationInfo")
    @RequestMapping(value = "/getShopDecorationInfo")
    public Result<ShopDecorationInfoRespDTO> getShopDecorationInfo(@RequestParam("shopId") long shopId){

        ShopDecorationInfoRespDTO shopDecorationInfoRespDTO = null;
        try {
            shopDecorationInfoRespDTO = shopDecorationService.getShopDecorationInfo(shopId);
            if(shopDecorationInfoRespDTO == null){
                return Result.wrap404Error("decoration is not found");
            }
        } catch (Exception e) {
            logger.error("getShopDecorationInfo faild with {}",shopId,e);
            return Result.wrap500Error(e.getMessage());
        }

        return new Result<>(shopDecorationInfoRespDTO);

    }
}
