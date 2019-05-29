package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PluginRepository extends JpaRepository<Plugin,Integer>, JpaSpecificationExecutor<Plugin> {

    List<Plugin> findAllByTypeOrderByOrders(String type);

    List<Plugin> findAllByTypeAndEnableOrderByOrders(String type,int enable);

    List<Plugin> findAllByEnableOrderByOrders(int enable);
}
