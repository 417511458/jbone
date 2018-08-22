package cn.jbone.b2b2c.shop.core.service;

import cn.jbone.b2b2c.shop.api.dto.response.*;
import cn.jbone.b2b2c.shop.core.dao.domain.*;
import cn.jbone.b2b2c.shop.core.dao.repository.ShopInfoRepository;
import cn.jbone.common.rpc.Result;
import cn.jbone.tag.api.TagApi;
import cn.jbone.tag.api.model.TagModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopReadService {

    @Autowired
    private ShopInfoRepository shopInfoRepository;

    @Autowired
    private TagApi tagApi;

    public ShopDetailsRespDTO getShopDetails(Long shopId){
        ShopInfoEntity shopInfoEntity = shopInfoRepository.findOne(shopId);
        if(shopInfoEntity == null){
            return null;
        }
        ShopDetailsRespDTO shopDetailsRespDTO = new ShopDetailsRespDTO();


        //店铺基本信息
        ShopInfoRespDTO shopInfoRespDTO = new ShopInfoRespDTO();
        BeanUtils.copyProperties(shopInfoEntity,shopInfoRespDTO);
        shopDetailsRespDTO.setShopInfo(shopInfoRespDTO);

        //店铺积分等级
        ShopCreditEntity shopCreditEntity = shopInfoEntity.getShopCredit();
        if(shopCreditEntity != null){
            ShopCreditRespDTO shopCreditRespDTO = new ShopCreditRespDTO();
            BeanUtils.copyProperties(shopCreditEntity,shopCreditRespDTO);
            shopDetailsRespDTO.setShopCredit(shopCreditRespDTO);
        }

        //营业时间
        ShopHoursEntity shopHoursEntity = shopInfoEntity.getShopHours();
        if(shopHoursEntity != null){
            ShopHoursRespDTO shopHoursRespDTO = new ShopHoursRespDTO();
            BeanUtils.copyProperties(shopHoursEntity,shopHoursRespDTO);
            shopDetailsRespDTO.setShopHours(shopHoursRespDTO);
        }

        //店铺GPS
        ShopGpsEntity shopGpsEntity = shopInfoEntity.getShopGps();
        if(shopGpsEntity != null){
            ShopGpsRespDTO shopGpsRespDTO = new ShopGpsRespDTO();
            BeanUtils.copyProperties(shopGpsEntity,shopGpsRespDTO);
            shopDetailsRespDTO.setShopGps(shopGpsRespDTO);
        }

        //店铺标签，从标签中心取标签名字
        List<ShopTagEntity> shopTagEntities = shopInfoEntity.getShopTags();
        if(shopTagEntities != null && !shopTagEntities.isEmpty()){
            List<ShopTagRespDTO> shopTagRespDTOS = new ArrayList<>();
            StringBuffer tagIdsSb = new StringBuffer();
            for (ShopTagEntity tagEntity:shopTagEntities){
                tagIdsSb.append(tagEntity.getTagId()).append(",");
            }
            String tagIds = tagIdsSb.substring(0,tagIdsSb.length()-1);
            Result<List<TagModel>> result = tagApi.batchGetTags(tagIds);
            if(result.isSuccess() && result.getData() != null && !result.getData().isEmpty()){
                List<TagModel> tagModels = result.getData();
                for (ShopTagEntity tagEntity:shopTagEntities){
                    for (TagModel tagModel:tagModels){
                        if(tagEntity.getTagId() == tagModel.getId()){
                            ShopTagRespDTO shopTagRespDTO = new ShopTagRespDTO();
                            shopTagRespDTO.setShopId(shopId);
                            shopTagRespDTO.setTagId(tagEntity.getTagId());
                            shopTagRespDTO.setTagName(tagModel.getName());
                            shopTagRespDTOS.add(shopTagRespDTO);
                        }
                    }
                }
            }

            shopDetailsRespDTO.setShopTags(shopTagRespDTOS);
        }

        return shopDetailsRespDTO;

    }
}
