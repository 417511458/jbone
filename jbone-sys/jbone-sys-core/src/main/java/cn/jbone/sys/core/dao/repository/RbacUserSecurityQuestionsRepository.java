package cn.jbone.sys.core.dao.repository;

import cn.jbone.sys.core.dao.domain.RbacUserSecurityQuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacUserSecurityQuestionsRepository extends JpaRepository<RbacUserSecurityQuestionsEntity,Integer>,JpaSpecificationExecutor<RbacUserSecurityQuestionsEntity> {
    List<RbacUserSecurityQuestionsEntity> findByUserId(int userId);
}
