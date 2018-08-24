package cn.jbone.b2b2c.decoration.core.dao.repository;

import cn.jbone.b2b2c.decoration.core.dao.domain.ShopDecorationTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDecorationTemplateRepository extends JpaRepository<ShopDecorationTemplateEntity,Long>,JpaSpecificationExecutor<ShopDecorationTemplateEntity> {
    ShopDecorationTemplateEntity findByShopId(long shopId);
}
