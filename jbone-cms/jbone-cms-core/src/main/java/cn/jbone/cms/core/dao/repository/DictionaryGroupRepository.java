package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.DictionaryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface DictionaryGroupRepository extends JpaRepository<DictionaryGroup,Integer>, JpaSpecificationExecutor<DictionaryGroup> {
    DictionaryGroup findByCode(String code);
}
