package cn.jbone.cms.core.dao.repository;

import cn.jbone.cms.core.dao.entity.DictionaryItem;
import cn.jbone.cms.core.dao.entity.DictionaryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface DictionaryItemRepository extends JpaRepository<DictionaryItem,Integer>, JpaSpecificationExecutor<DictionaryItem> {
    boolean existsByGroup(DictionaryGroup group);
}
