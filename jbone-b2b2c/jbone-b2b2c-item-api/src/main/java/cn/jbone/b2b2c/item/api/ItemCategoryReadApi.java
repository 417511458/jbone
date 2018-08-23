package cn.jbone.b2b2c.item.api;

import cn.jbone.b2b2c.item.api.response.ItemCategoryTreeRespDTO;
import cn.jbone.b2b2c.item.api.response.ShopCagetoryItemsRespDTO;
import cn.jbone.common.rpc.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 读取商品分类API
 */
public interface ItemCategoryReadApi {


    /**
     * 获取店铺分类树
     * @param shopId 店铺ID
     * @return 店铺分类树
     */
    @HystrixCommand(commandKey = "getItemCategoryTree")
    @RequestMapping(value = "/getItemCategoryTree")
    Result<List<ItemCategoryTreeRespDTO>> getItemCategoryTree(@RequestParam("shopId") long shopId);


    /**
     * 获取店铺分类及下面的商品
     * @param shopId 店铺ID
     * @return 获取店铺分类及下面的商品
     */
    @HystrixCommand(commandKey = "getShopCategoryItems")
    @RequestMapping(value = "/getShopCategoryItems")
    Result<List<ShopCagetoryItemsRespDTO>> getShopCategoryItems(@RequestParam("shopId") long shopId);
}
