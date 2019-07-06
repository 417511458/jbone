package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LinkRepository extends JpaRepository<Link,Long>, JpaSpecificationExecutor<Link> {
    List<Link> findAllBySiteIdOrderByOrders(Integer siteId);
    long countBySiteId(Integer siteId);
}
