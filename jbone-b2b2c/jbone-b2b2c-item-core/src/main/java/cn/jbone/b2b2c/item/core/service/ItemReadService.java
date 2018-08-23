package cn.jbone.b2b2c.item.core.service;

import cn.jbone.b2b2c.item.api.request.GetItemTopListReqDTO;
import cn.jbone.b2b2c.item.api.response.ItemBaseInfoRespDTO;
import cn.jbone.b2b2c.item.core.consts.CommonConstant;
import cn.jbone.b2b2c.item.core.dao.domain.ItemInfoEntity;
import cn.jbone.b2b2c.item.core.dao.repository.ItemInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemReadService {
    @Autowired
    ItemInfoRepository itemInfoRepository;

    /**
     * 获取商品排行
     * @param getItemTopListReqDTO
     * @return
     */
    public List<ItemBaseInfoRespDTO> getItemTopList(GetItemTopListReqDTO getItemTopListReqDTO){
        PageRequest pageRequest = new PageRequest(0,getItemTopListReqDTO.getSize());
        List<ItemInfoEntity> itemInfoEntities = itemInfoRepository.findByShopIdAndStatusOrderBySoldDesc(pageRequest,getItemTopListReqDTO.getShopId(),CommonConstant.ITEM_STATUS_UP);

        if(itemInfoEntities != null && !itemInfoEntities.isEmpty()){
            List<ItemBaseInfoRespDTO> itemBaseInfoRespDTOS = new ArrayList<>();
            for (ItemInfoEntity itemInfoEntity : itemInfoEntities){
                ItemBaseInfoRespDTO itemBaseInfoRespDTO = new ItemBaseInfoRespDTO();
                BeanUtils.copyProperties(itemInfoEntity,itemBaseInfoRespDTO);
                itemBaseInfoRespDTOS.add(itemBaseInfoRespDTO);
            }
            return itemBaseInfoRespDTOS;
        }
        return null;

    }
}
