package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.SiteSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteSettingsRepository extends JpaRepository<SiteSettings,Long>, JpaSpecificationExecutor<SiteSettings> {
    List<SiteSettings> findBySiteId(Integer siteId);
    SiteSettings findBySiteIdAndName(Integer siteId,String name);
}
