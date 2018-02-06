package com.majunwei.jbone.sys.dao.repository;

import com.majunwei.jbone.sys.dao.domain.RbacRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacRoleRepository extends JpaRepository<RbacRoleEntity,Integer>,JpaSpecificationExecutor<RbacRoleEntity> {
    List<RbacRoleEntity> findByIdIn(int[] ids);
}
