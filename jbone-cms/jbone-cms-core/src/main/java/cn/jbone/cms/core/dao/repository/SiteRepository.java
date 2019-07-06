package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteRepository extends JpaRepository<Site,Integer>, JpaSpecificationExecutor<Site> {
    Site findByDomainAndEnable(String domain,int enable);
    List<Site> findByIdInAndPid(List<Integer> ids,int pid);
    List<Site> findByDomainOrAlias1OrAlias2(String domain,String alias1,String alias2);
}
