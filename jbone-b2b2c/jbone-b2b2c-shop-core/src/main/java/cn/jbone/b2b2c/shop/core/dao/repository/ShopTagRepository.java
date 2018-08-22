package cn.jbone.b2b2c.shop.core.dao.repository;

import cn.jbone.b2b2c.shop.core.dao.domain.ShopTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopTagRepository extends JpaRepository<ShopTagEntity,Long>,JpaSpecificationExecutor<ShopTagEntity> {
}
