package cn.jbone.b2b2c.shop.api;

import cn.jbone.b2b2c.shop.api.dto.response.ShopDetailsRespDTO;
import cn.jbone.common.rpc.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 读取店铺信息接口定义
 */
public interface ShopReadApi {

    /**
     * 获取店铺详情，包含店铺基本信息、积分等级、营业时间等
     * @param shopId 店铺ID
     * @return 店铺详情
     */
    @HystrixCommand(commandKey = "getShopDetails")
    @RequestMapping(value = "/getShopDetails")
    Result<ShopDetailsRespDTO> getShopDetails(@RequestParam("shopId") Long shopId);
}
