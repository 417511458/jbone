package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.common.enums.StatusEnum;
import cn.jbone.cms.core.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>, JpaSpecificationExecutor<Category> {

    List<Category> findAllByPid(long pid);

    List<Category> findAllByPidAndStatus(long pid, StatusEnum status);

    long countByPid(long pid);

    long countById(long id);

}
