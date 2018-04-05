package cn.jbone.eb.portal.core.dao.repository;

import cn.jbone.eb.portal.core.dao.domain.IndexModuleConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexModuleConfigRepository extends JpaRepository<IndexModuleConfigEntity,Integer>,JpaSpecificationExecutor<IndexModuleConfigEntity> {
}
