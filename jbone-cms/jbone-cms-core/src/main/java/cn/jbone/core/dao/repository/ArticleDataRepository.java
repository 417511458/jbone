package cn.jbone.core.dao.repository;

import cn.jbone.core.dao.entity.ArticleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDataRepository extends JpaRepository<ArticleData,Long>, JpaSpecificationExecutor<ArticleData> {
}
