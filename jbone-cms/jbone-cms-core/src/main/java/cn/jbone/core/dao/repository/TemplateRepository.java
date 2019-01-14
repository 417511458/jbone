package cn.jbone.core.dao.repository;

import cn.jbone.core.dao.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends JpaRepository<Template,Long>, JpaSpecificationExecutor<Template> {
}
