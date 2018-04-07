package cn.jbone.eb.portal.core.service;

import cn.jbone.common.service.AbstractService;
import cn.jbone.common.service.bo.SearchListBO;
import cn.jbone.eb.portal.core.dao.domain.IndexModuleConfigEntity;
import cn.jbone.eb.portal.core.dao.repository.IndexModuleConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class IndexModuleConfigService extends AbstractService<IndexModuleConfigEntity> {
    @Autowired
    private IndexModuleConfigRepository indexModuleConfigRepository;
    public Page<IndexModuleConfigEntity> findByPage(SearchListBO searchListBO){
        return indexModuleConfigRepository.findAll(getSearchListSpecification(searchListBO),getPageRequest(searchListBO));
    }
}
