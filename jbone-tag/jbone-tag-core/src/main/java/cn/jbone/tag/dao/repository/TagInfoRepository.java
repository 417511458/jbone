package cn.jbone.tag.dao.repository;

import cn.jbone.tag.dao.domain.TagInfoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 2:16
 */
@Repository
public interface TagInfoRepository extends JpaRepository<TagInfoEntity,Integer>, JpaSpecificationExecutor<TagInfoEntity>{
    /**
     * @param id 主键
     * @return TagInfoEntity
     */
    TagInfoEntity findById(int id);

    @Query(value = "SELECT ti FROM TagInfoEntity ti WHERE ti.id in :tagsId ")
    List<TagInfoEntity> findById(@Param("tagsId") List<Integer> tagsId);

    @Query("SELECT ti FROM TagInfoEntity ti WHERE ti.target in :targetList ")
    List<TagInfoEntity> findByTarget(@Param("targetList") List<Integer> targetList, Pageable pageable);
}
