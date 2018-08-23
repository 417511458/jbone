package cn.jbone.b2b2c.item.core.dao.repository;

import cn.jbone.b2b2c.item.core.dao.domain.ItemCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemCategoryRepository extends JpaRepository<ItemCategoryEntity,Long>,JpaSpecificationExecutor<ItemCategoryEntity> {
    List<ItemCategoryEntity> findByShopIdAndPidAndStatusOrderBySortNumDesc(long shopId,long pid,int status);

    List<ItemCategoryEntity> findByShopIdAndStatusOrderBySortNumDesc(long shopId,int status);
}
