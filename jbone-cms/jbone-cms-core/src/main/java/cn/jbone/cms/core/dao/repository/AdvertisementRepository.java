package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement,Long>, JpaSpecificationExecutor<Advertisement> {
    long countBySiteId(Integer siteId);
}
