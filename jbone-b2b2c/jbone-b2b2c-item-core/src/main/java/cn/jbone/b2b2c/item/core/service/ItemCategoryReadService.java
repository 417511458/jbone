package cn.jbone.b2b2c.item.core.service;

import cn.jbone.b2b2c.item.api.response.ItemBaseInfoRespDTO;
import cn.jbone.b2b2c.item.api.response.ItemCategoryTreeRespDTO;
import cn.jbone.b2b2c.item.api.response.ShopCagetoryItemsRespDTO;
import cn.jbone.b2b2c.item.core.consts.CommonConstant;
import cn.jbone.b2b2c.item.core.dao.domain.ItemCategoryEntity;
import cn.jbone.b2b2c.item.core.dao.domain.ItemCategoryRelationEntity;
import cn.jbone.b2b2c.item.core.dao.domain.ItemInfoEntity;
import cn.jbone.b2b2c.item.core.dao.repository.ItemCategoryRelationRepository;
import cn.jbone.b2b2c.item.core.dao.repository.ItemCategoryRepository;
import cn.jbone.b2b2c.item.core.dao.repository.ItemInfoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCategoryReadService {

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;
    @Autowired
    private ItemCategoryRelationRepository itemCategoryRelationRepository;
    @Autowired
    private ItemInfoRepository itemInfoRepository;

    /**
     * 获取菜单树,商品的菜单树只支持两极
     * @param shopId 店铺ID
     * @return
     */
    public List<ItemCategoryTreeRespDTO> getItemCategoryTree(long shopId) {
        List<ItemCategoryEntity> itemCategoryEntities = itemCategoryRepository.findByShopIdAndPidAndStatusOrderBySortNumDesc(shopId,CommonConstant.ROOT_ID,CommonConstant.STATUS_VALID);
        if(itemCategoryEntities == null || itemCategoryEntities.isEmpty()){
            return null;
        }
        List<ItemCategoryTreeRespDTO> itemCategoryTreeRespDTOS = new ArrayList<>();
        for(ItemCategoryEntity itemCategoryEntity : itemCategoryEntities){
            ItemCategoryTreeRespDTO itemCategoryTreeRespDTO = new ItemCategoryTreeRespDTO();
            itemCategoryTreeRespDTO.setId(itemCategoryEntity.getId());
            itemCategoryTreeRespDTO.setName(itemCategoryEntity.getName());

            //只支持两级
            List<ItemCategoryEntity> children = itemCategoryRepository.findByShopIdAndPidAndStatusOrderBySortNumDesc(shopId,itemCategoryEntity.getId(),CommonConstant.STATUS_VALID);
            if(children != null && !children.isEmpty()){
                List<ItemCategoryTreeRespDTO> childCatgorys = new ArrayList<>();
                for(ItemCategoryEntity childItemCategory : children) {
                    ItemCategoryTreeRespDTO childTree = new ItemCategoryTreeRespDTO();
                    childTree.setId(childItemCategory.getId());
                    childTree.setName(childItemCategory.getName());

                    childCatgorys.add(childTree);

                }
                itemCategoryTreeRespDTO.setChildren(childCatgorys);
            }

            itemCategoryTreeRespDTOS.add(itemCategoryTreeRespDTO);
        }
        return itemCategoryTreeRespDTOS;
    }

    /**
     * 获取菜单和及联的商品
     * @param shopId
     * @return
     */
    public List<ShopCagetoryItemsRespDTO> getShopCategoryItems(long shopId) {
        List<ItemCategoryEntity> itemCategoryEntities = itemCategoryRepository.findByShopIdAndPidAndStatusOrderBySortNumDesc(shopId,CommonConstant.ROOT_ID,CommonConstant.STATUS_VALID);
        if(itemCategoryEntities == null || itemCategoryEntities.isEmpty()){
            return null;
        }

        List<ShopCagetoryItemsRespDTO> list = new ArrayList<>();
        for(ItemCategoryEntity itemCategoryEntity : itemCategoryEntities) {
            ShopCagetoryItemsRespDTO shopCagetoryItemsRespDTO = new ShopCagetoryItemsRespDTO();
            shopCagetoryItemsRespDTO.setId(itemCategoryEntity.getId());
            shopCagetoryItemsRespDTO.setName(itemCategoryEntity.getName());

            //过滤掉未上架的商品
            List<ItemCategoryRelationEntity> itemCategoryRelationEntities = itemCategoryEntity.getItemCategoryRelations();

            if(itemCategoryRelationEntities != null && !itemCategoryRelationEntities.isEmpty()){
                List<ItemInfoEntity> itemInfoEntities = itemInfoRepository.findByItemCategoryRelationsAndStatusOrderBySoldDesc(new PageRequest(0,4),itemCategoryRelationEntities,CommonConstant.STATUS_VALID);

                List<ItemBaseInfoRespDTO> itemBaseInfoRespDTOS = new ArrayList<>();
                for(ItemInfoEntity itemInfoEntity : itemInfoEntities){
                    ItemBaseInfoRespDTO itemBaseInfoRespDTO = new ItemBaseInfoRespDTO();
                    BeanUtils.copyProperties(itemInfoEntity,itemBaseInfoRespDTO);
                    itemBaseInfoRespDTOS.add(itemBaseInfoRespDTO);
                }
                shopCagetoryItemsRespDTO.setItems(itemBaseInfoRespDTOS);
            }

            //只返回存在商品的分类
            if(shopCagetoryItemsRespDTO.getItems() != null && !shopCagetoryItemsRespDTO.getItems().isEmpty()){
                list.add(shopCagetoryItemsRespDTO);
            }

        }

        return list;
    }
}
