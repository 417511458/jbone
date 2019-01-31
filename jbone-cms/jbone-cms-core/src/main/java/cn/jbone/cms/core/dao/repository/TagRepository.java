package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.Tag;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long>, JpaSpecificationExecutor<Tag> {
    List<Tag> findByNameContaining(String name);
}
