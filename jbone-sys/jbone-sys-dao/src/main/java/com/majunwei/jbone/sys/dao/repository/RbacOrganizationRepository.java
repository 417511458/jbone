package com.majunwei.jbone.sys.dao.repository;

import com.majunwei.jbone.sys.dao.domain.RbacOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacOrganizationRepository extends JpaRepository<RbacOrganizationEntity,Integer>,JpaSpecificationExecutor<RbacOrganizationEntity> {
    List<RbacOrganizationEntity> findByPid(int pid);

    List<RbacOrganizationEntity> findByIdIn(int[] ids);
}
