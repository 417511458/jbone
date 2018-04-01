package cn.jbone.sys.core.dao.repository;

import cn.jbone.sys.core.dao.domain.RbacPermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacPermissionRepository extends JpaRepository<RbacPermissionEntity,Integer>,JpaSpecificationExecutor<RbacPermissionEntity> {
    List<RbacPermissionEntity> findBySystemId(int systemId);
    List<RbacPermissionEntity> findBySystemIdAndMenuId(int systemId, int menuId);
    List<RbacPermissionEntity> findByIdIn(int[] ids);
}
