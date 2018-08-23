package cn.jbone.b2b2c.item.core.dao.repository;

import cn.jbone.b2b2c.item.core.dao.domain.ItemSkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSkuRepository extends JpaRepository<ItemSkuEntity,Long>,JpaSpecificationExecutor<ItemSkuEntity> {

}
