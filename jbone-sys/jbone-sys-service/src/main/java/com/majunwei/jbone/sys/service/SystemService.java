package com.majunwei.jbone.sys.service;

import com.majunwei.jbone.sys.dao.domain.RbacSystemEntity;
import com.majunwei.jbone.sys.dao.repository.RbacSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.List;

@Service
public class SystemService {

    @Autowired
    private RbacSystemRepository rbacSystemRepository;
    /**
     * 这里的service即casFilter
     * @param service
     * @return
     */
    public String findServiceTheme(String service){
        List<RbacSystemEntity> systemEntities = rbacSystemRepository.findByServiceCasFilterOrderByServiceEvaluationOrderDesc(service);

        if(systemEntities != null && !systemEntities.isEmpty()){
            RbacSystemEntity entity = systemEntities.get(0);
            return entity.getServiceThemePath();
        }

        return "cas-theme-default";
    }


    public Page<RbacSystemEntity> findPage(String condition, Pageable pageable){
        return rbacSystemRepository.findAll(new SystemSpecification(condition),pageable);
    }


    private class SystemSpecification implements Specification<RbacSystemEntity> {
        private String condition;
        public SystemSpecification(String condition){
            this.condition = condition;
        }
        @Override
        public Predicate toPredicate(Root<RbacSystemEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(StringUtils.isEmpty(condition)){
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("name");
            Path<String> title = root.get("title");
            Path<String> basepath = root.get("basepath");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name,"%" + condition + "%"),criteriaBuilder.like(title,"%" + condition + "%"),criteriaBuilder.like(basepath,"%" + condition + "%"));
            return predicate;
        }
    }
}
