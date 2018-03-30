package cn.jbone.tag.dao.repository;

import cn.jbone.tag.dao.domain.TagInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

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
}
