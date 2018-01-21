package com.majunwei.jbone.sys.dao.repository;

import com.majunwei.jbone.sys.dao.domain.RbacMenuEntity;
import com.majunwei.jbone.sys.dao.domain.RbacRoleEntity;
import com.majunwei.jbone.sys.dao.domain.RbacUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RbacMenuRepository extends JpaRepository<RbacMenuEntity,Integer>,JpaSpecificationExecutor<RbacMenuEntity> {
    List<RbacMenuEntity> findByPidAndSystemId(int pid,int systemId);
    @Query("select m from RbacMenuEntity m where (m.roles in (:roles) and m.users in (:users)) and m.pid = :pid")
    List<RbacMenuEntity> findByRolesInOrUsersInAndPidOrderByOrders(@Param("roles") List<RbacRoleEntity> roles, @Param("users") List<RbacUserEntity> users , @Param("pid") int pid);

    List<RbacMenuEntity> findDistinctByRolesInAndPidOrderByOrders(List<RbacRoleEntity> roles,int pid);

    List<RbacMenuEntity> findDistinctByUsersInAndPidOrderByOrders(List<RbacUserEntity> users,int pid);
}
