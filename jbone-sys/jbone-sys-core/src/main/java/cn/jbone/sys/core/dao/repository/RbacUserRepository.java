package cn.jbone.sys.core.dao.repository;

import cn.jbone.sys.core.dao.domain.RbacUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RbacUserRepository extends JpaRepository<RbacUserEntity,Integer>,JpaSpecificationExecutor<RbacUserEntity>{
    RbacUserEntity findByUsername(String username);
}
