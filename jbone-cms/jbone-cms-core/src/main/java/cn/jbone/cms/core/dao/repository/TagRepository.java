package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Tag;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long>, JpaSpecificationExecutor<Tag> {
    List<Tag> findByNameContainingAndSiteId(String name,Integer siteId);

    List<Tag> findByIdIn(List<Long> ids);

    List<Tag> findBySiteId(Integer siteId);

    @Query(value = "SELECT count(*) FROM ARTICLE_TAG", nativeQuery = true)
    long articleTagCount();

    @Query(value = "SELECT * from TAG where id in (select distinct tag_id from ARTICLE_TAG)",nativeQuery = true)
    List<Tag> findTagCloud();

    long countBySiteId(Integer siteId);

}
