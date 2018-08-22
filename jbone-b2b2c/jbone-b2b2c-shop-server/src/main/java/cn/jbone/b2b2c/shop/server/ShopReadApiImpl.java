package cn.jbone.b2b2c.shop.server;

import cn.jbone.b2b2c.shop.api.ShopReadApi;
import cn.jbone.b2b2c.shop.api.dto.response.ShopDetailsRespDTO;
import cn.jbone.b2b2c.shop.core.service.ShopReadService;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopReadApiImpl implements ShopReadApi {

    private Logger logger = LoggerFactory.getLogger(ShopReadApiImpl.class);

    @Autowired
    private ShopReadService shopReadService;

    @RequestMapping("/getShopDetails")
    public Result<ShopDetailsRespDTO> getShopDetails(@RequestParam("shopId")Long shopId) {
        ShopDetailsRespDTO shopDetailsRespDTO = null;
        try {
            shopDetailsRespDTO = shopReadService.getShopDetails(shopId);
            if(shopDetailsRespDTO == null){
                return Result.wrap404Error("Shop is not found with " + shopId);
            }
        } catch (Exception e) {
            logger.error("getShopDetails error ",e);
            return Result.wrap500Error(e.getMessage());
        }
        return new Result<>(shopDetailsRespDTO);
    }
}
