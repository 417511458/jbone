package cn.jbone.b2b2c.shop.core.dao.repository;

import cn.jbone.b2b2c.shop.core.dao.domain.ShopInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopInfoRepository extends JpaRepository<ShopInfoEntity,Long>,JpaSpecificationExecutor<ShopInfoEntity> {
}
