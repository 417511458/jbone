package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long>, JpaSpecificationExecutor<Comment> {
    long countByArticleId(Long articleId);

    List<Comment> findByArticleIdOrderByAddTimeDesc(Long articleId);

    long countBySiteId(Integer siteId);
}
