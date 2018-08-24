package cn.jbone.b2b2c.decoration.api;

import cn.jbone.b2b2c.decoration.api.dto.response.ShopDecorationInfoRespDTO;
import cn.jbone.common.rpc.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 读取装修接口
 */
public interface DecorationReadApi {
    /**
     * 获取店铺装修信息
     * @return 商品排行榜
     */
    @HystrixCommand(commandKey = "getShopDecorationInfo")
    @RequestMapping(value = "/getShopDecorationInfo")
    Result<ShopDecorationInfoRespDTO> getShopDecorationInfo(@RequestParam("shopId") long shopId);
}
