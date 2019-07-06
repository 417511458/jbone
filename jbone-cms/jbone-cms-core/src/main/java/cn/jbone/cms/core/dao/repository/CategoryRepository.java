package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.common.enums.BooleanEnum;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.cms.core.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Category> {

    List<Category> findAllByPidAndSiteIdOrderByOrders(long pid,Integer siteId);

    List<Category> findAllByPidAndStatus(long pid, StatusEnum status);

    List<Category> findAllByPidAndStatusAndInMenuAndSiteIdOrderByOrders(long pid, StatusEnum status, BooleanEnum inMenu,Integer siteId);

    List<Category> findByIdIn(List<Long> ids);

    long countByPid(long pid);

    long countById(long id);

    long countByType(CategoryTypeEnum type);

    long countBySiteId(Integer siteId);

}
