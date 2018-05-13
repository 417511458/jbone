package cn.jbone.sys.core.dao.repository;

import cn.jbone.sys.core.dao.domain.RbacUserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RbacUserRoleRepository extends JpaRepository<RbacUserRoleEntity,Integer>,JpaSpecificationExecutor<RbacUserRoleEntity> {
    void deleteByUserId(int userId);
}
