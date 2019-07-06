package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PluginRepository extends JpaRepository<Plugin,Integer>, JpaSpecificationExecutor<Plugin> {

    List<Plugin> findAllByTypeAndSiteIdOrderByOrders(String type,Integer siteId);

    List<Plugin> findAllByTypeAndEnableAndSiteIdOrderByOrders(String type,int enable,Integer siteId);

    List<Plugin> findAllByEnableAndSiteIdOrderByOrders(int enable,Integer siteId);

    List<Plugin> findAllBySiteIdOrderByOrders(Integer siteId);

    long countBySiteId(Integer siteId);
}
