package cn.jbone.sys.core.dao.repository;

import cn.jbone.sys.core.dao.domain.RbacOrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacOrganizationRepository extends JpaRepository<RbacOrganizationEntity,Integer>,JpaSpecificationExecutor<RbacOrganizationEntity> {
    List<RbacOrganizationEntity> findByPid(int pid);

    List<RbacOrganizationEntity> findByIdIn(int[] ids);
}
