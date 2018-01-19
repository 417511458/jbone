package com.majunwei.jbone.sys.dao.repository;

import com.majunwei.jbone.sys.dao.domain.RbacMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacMenuRepository extends JpaRepository<RbacMenuEntity,Integer>,JpaSpecificationExecutor<RbacMenuEntity> {
    List<RbacMenuEntity> findByPidAndSystemId(int pid,int systemId);
}
