package cn.jbone.b2b2c.item.core.dao.repository;

import cn.jbone.b2b2c.item.core.dao.domain.ItemSkuStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSkuStockRepository extends JpaRepository<ItemSkuStockEntity,Long>,JpaSpecificationExecutor<ItemSkuStockEntity> {

}
