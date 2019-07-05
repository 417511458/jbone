package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.SiteAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteAdminRepository extends JpaRepository<SiteAdmin,Long>, JpaSpecificationExecutor<SiteAdmin> {
    List<SiteAdmin> findBySiteId(Integer siteId);
    List<SiteAdmin> findByUserId(Integer userId);
    boolean existsBySiteIdAndUserId(Integer siteId,Integer userId);
}
