package cn.jbone.b2b2c.decoration.core.dao.repository;

import cn.jbone.b2b2c.decoration.core.dao.domain.DecorationTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DecorationTemplateRepository extends JpaRepository<DecorationTemplateEntity,Long>,JpaSpecificationExecutor<DecorationTemplateEntity> {
}
