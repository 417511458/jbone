package com.majunwei.jbone.sys.dao.repository;

import com.majunwei.jbone.sys.dao.domain.RbacPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RbacPermissionRepository extends JpaRepository<RbacPermissionEntity,Integer>,JpaSpecificationExecutor<RbacPermissionEntity> {
}
