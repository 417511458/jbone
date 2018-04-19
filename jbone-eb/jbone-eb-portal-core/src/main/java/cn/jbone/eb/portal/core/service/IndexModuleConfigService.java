package cn.jbone.eb.portal.core.service;

import cn.jbone.common.api.dto.SearchListDTO;
import cn.jbone.common.service.AbstractService;
import cn.jbone.eb.portal.core.dao.domain.IndexModuleConfigEntity;
import cn.jbone.eb.portal.core.dao.repository.IndexModuleConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class IndexModuleConfigService extends AbstractService<IndexModuleConfigEntity> {
    @Autowired
    private IndexModuleConfigRepository indexModuleConfigRepository;
    public Page<IndexModuleConfigEntity> findByPage(SearchListDTO searchListDTO){
        return indexModuleConfigRepository.findAll(getSearchListSpecification(searchListDTO),getPageRequest(searchListDTO));
    }
}
