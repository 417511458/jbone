package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long>, JpaSpecificationExecutor<Article> {
    long countByTags(List<Tag> tags);

    @Query("select sum(o.hits) from Article as o")
    long findHitsCount();

    long countBySiteId(Integer siteId);
}
