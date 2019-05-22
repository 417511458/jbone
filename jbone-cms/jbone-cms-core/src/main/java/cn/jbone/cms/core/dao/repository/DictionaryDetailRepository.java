package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.DictionaryDetail;
import cn.jbone.cms.core.dao.entity.DictionaryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface DictionaryDetailRepository extends JpaRepository<DictionaryDetail,Integer>, JpaSpecificationExecutor<DictionaryDetail> {
    boolean existsByGroup(DictionaryGroup group);
}
