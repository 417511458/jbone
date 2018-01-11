package com.majunwei.jbone.sys.dao.repository;

import com.majunwei.jbone.sys.dao.domain.RbacSystemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacSystemRepository extends JpaRepository<RbacSystemEntity,Integer>,JpaSpecificationExecutor<RbacSystemEntity> {
    List<RbacSystemEntity> findByServiceCasFilterOrderByServiceEvaluationOrderDesc(String serviceCasFilter);
}
