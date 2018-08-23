package cn.jbone.b2b2c.item.server;

import cn.jbone.b2b2c.item.api.ItemCategoryReadApi;
import cn.jbone.b2b2c.item.api.response.ItemCategoryTreeRespDTO;
import cn.jbone.b2b2c.item.api.response.ShopCagetoryItemsRespDTO;
import cn.jbone.b2b2c.item.core.service.ItemCategoryReadService;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemCategoryReadApiImpl implements ItemCategoryReadApi {

    Logger logger = LoggerFactory.getLogger(ItemCategoryReadApiImpl.class);

    @Autowired
    private ItemCategoryReadService itemCategoryReadService;

    @RequestMapping(value = "/getItemCategoryTree")
    public Result<List<ItemCategoryTreeRespDTO>> getItemCategoryTree(@RequestParam("shopId")long shopId) {
        List<ItemCategoryTreeRespDTO> itemCategoryTreeRespDTOS = null;
        try {
            itemCategoryTreeRespDTOS = itemCategoryReadService.getItemCategoryTree(shopId);
            if(itemCategoryTreeRespDTOS == null){
                return Result.wrap404Error("itemCategory is not found");
            }
        } catch (Exception e) {
            logger.error("getItemCategoryTree error with {}",shopId,e);
            return Result.wrap500Error(e.getMessage());

        }
        return new Result<>(itemCategoryTreeRespDTOS);
    }

    @RequestMapping(value = "/getShopCategoryItems")
    public Result<List<ShopCagetoryItemsRespDTO>> getShopCategoryItems(@RequestParam("shopId") long shopId) {
        List<ShopCagetoryItemsRespDTO> shopCagetoryItemsRespDTOS = null;
        try {
            shopCagetoryItemsRespDTOS = itemCategoryReadService.getShopCategoryItems(shopId);
            if(shopCagetoryItemsRespDTOS == null){
                return Result.wrap404Error("itemCategory is not found");
            }
        } catch (Exception e) {
            logger.error("getShopCategoryItems error with {}",shopId,e);
            return Result.wrap500Error(e.getMessage());

        }
        return new Result<>(shopCagetoryItemsRespDTOS);
    }
}
