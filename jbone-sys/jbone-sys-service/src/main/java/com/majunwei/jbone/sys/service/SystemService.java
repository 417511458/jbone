package com.majunwei.jbone.sys.service;

import com.majunwei.jbone.sys.dao.domain.RbacSystemEntity;
import com.majunwei.jbone.sys.dao.repository.RbacSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if(systemEntities != null){
            RbacSystemEntity entity = systemEntities.get(0);
            return entity.getServiceThemePath();
        }

        return null;
    }
}
