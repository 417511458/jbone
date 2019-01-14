package cn.jbone.b2b2c.item.server;

import cn.jbone.b2b2c.item.api.ItemReadApi;
import cn.jbone.b2b2c.item.api.request.GetItemTopListReqDTO;
import cn.jbone.b2b2c.item.api.response.ItemBaseInfoRespDTO;
import cn.jbone.b2b2c.item.core.service.ItemReadService;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ItemReadApiImpl implements ItemReadApi {

    @Autowired
    ItemReadService itemReadService;

    private Logger logger = LoggerFactory.getLogger(ItemReadApiImpl.class);

    @RequestMapping(value = "/getItemTopList", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<ItemBaseInfoRespDTO>> getItemTopList(@RequestBody GetItemTopListReqDTO getItemTopListReqDTO) {
        List<ItemBaseInfoRespDTO> itemBaseInfoRespDTOS = null;
        try {
            itemBaseInfoRespDTOS = itemReadService.getItemTopList(getItemTopListReqDTO);
            if(itemBaseInfoRespDTOS == null){
                return Result.wrap404Error("items is not found");
            }
        } catch (Exception e) {
            logger.error("getItemTopList error",e);
            return Result.wrap500Error(e.getMessage());
        }
        return new Result(itemBaseInfoRespDTOS);
    }


    @RequestMapping(value = "getItemDetail")
    public Result getItemDetail(@RequestParam("itemId") long itemId) {
        return null;
    }
}
