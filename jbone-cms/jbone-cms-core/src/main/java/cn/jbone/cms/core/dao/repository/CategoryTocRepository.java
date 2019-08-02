package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.entity.Category;
import cn.jbone.cms.core.dao.entity.CategoryToc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryTocRepository extends JpaRepository<CategoryToc,Long>, JpaSpecificationExecutor<CategoryToc> {
    long countByPid(long pid);

    List<CategoryToc> findAllByCategoryAndPidOrderByOrders(Category category,long pid);

    List<CategoryToc> findAllByCategoryAndArticle(Category category, Article article);
}
