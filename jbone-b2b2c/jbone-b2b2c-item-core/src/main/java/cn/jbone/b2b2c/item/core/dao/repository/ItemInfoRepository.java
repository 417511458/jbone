package cn.jbone.b2b2c.item.core.dao.repository;

import cn.jbone.b2b2c.item.core.dao.domain.ItemCategoryRelationEntity;
import cn.jbone.b2b2c.item.core.dao.domain.ItemInfoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemInfoRepository extends JpaRepository<ItemInfoEntity,Long>,JpaSpecificationExecutor<ItemInfoEntity> {

    /**
     * 获取 商品销量排行榜
     * @param pageable
     * @param shopId
     * @param status
     * @return
     */
    List<ItemInfoEntity> findByShopIdAndStatusOrderBySoldDesc(Pageable pageable,long shopId,int status);

    List<ItemInfoEntity> findByItemCategoryRelationsAndStatusOrderBySoldDesc(Pageable pageable, List<ItemCategoryRelationEntity> itemCategoryRelationEntities, int status);
}
