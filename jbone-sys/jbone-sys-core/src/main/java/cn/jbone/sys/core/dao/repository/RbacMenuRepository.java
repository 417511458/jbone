package cn.jbone.sys.core.dao.repository;

import cn.jbone.sys.core.dao.domain.RbacMenuEntity;
import cn.jbone.sys.core.dao.domain.RbacRoleEntity;
import cn.jbone.sys.core.dao.domain.RbacUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacMenuRepository extends JpaRepository<RbacMenuEntity,Integer>,JpaSpecificationExecutor<RbacMenuEntity> {
    List<RbacMenuEntity> findByPidAndSystemIdOrderByOrdersDesc(int pid, int systemId);
    @Query("select m from RbacMenuEntity m where (m.roles in (:roles) and m.users in (:users)) and m.pid = :pid")
    List<RbacMenuEntity> findByRolesInOrUsersInAndPidOrderByOrders(@Param("roles") List<RbacRoleEntity> roles, @Param("users") List<RbacUserEntity> users, @Param("pid") int pid);

    List<RbacMenuEntity> findDistinctByRolesInAndPidAndSystemIdOrderByOrdersDesc(List<RbacRoleEntity> roles, int pid, int systemId);

    List<RbacMenuEntity> findDistinctByUsersInAndPidAndSystemIdOrderByOrdersDesc(List<RbacUserEntity> users, int pid, int systemId);

    List<RbacMenuEntity> findDistinctByRolesInAndPidOrderByOrdersDesc(List<RbacRoleEntity> roles, int pid);

    List<RbacMenuEntity> findDistinctByUsersInAndPidOrderByOrdersDesc(List<RbacUserEntity> users, int pid);

    List<RbacMenuEntity> findByIdIn(int[] ids);
}
