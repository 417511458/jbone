package cn.jbone.b2b2c.item.api;

import cn.jbone.b2b2c.item.api.request.GetItemTopListReqDTO;
import cn.jbone.b2b2c.item.api.response.ItemBaseInfoRespDTO;
import cn.jbone.b2b2c.item.api.response.ItemDetailRespDTO;
import cn.jbone.common.rpc.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 读取商品信息列表
 */
public interface ItemReadApi {
    /**
     * 获取商品排行榜
     * @param getItemTopListReqDTO 查询参数
     * @return 商品排行榜
     */
    @HystrixCommand(commandKey = "getItemTopList")
    @RequestMapping(value = "/getItemTopList")
    Result<List<ItemBaseInfoRespDTO>> getItemTopList(@RequestBody GetItemTopListReqDTO getItemTopListReqDTO);

    /**
     * 获取商品详情
     * @param itemId 商品ID
     * @return
     */
    @HystrixCommand(commandKey = "getItemDetail")
    @RequestMapping(value = "/getItemDetail")
    Result<ItemDetailRespDTO> getItemDetail(@RequestParam("itemId") long itemId);
}
