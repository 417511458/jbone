package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.core.converter.TemplateConverter;
import cn.jbone.cms.core.dao.entity.Template;
import cn.jbone.cms.core.dao.repository.TemplateRepository;
import cn.jbone.common.exception.ObjectNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class TemplateService {

    @Autowired
    private TemplateConverter templateConverter;
    @Autowired
    private TemplateRepository templateRepository;

    public void delete(Long id){
        if(!templateRepository.existsById(id)){
            throw new ObjectNotFoundException("模版不存在");
        }
        templateRepository.deleteById(id);
    }

    public void addOrUpdate(TemplateDO templateDO){
        checkParam(templateDO);
        Template template = templateConverter.toTemplate(templateDO);
        templateRepository.save(template);
    }

    public TemplateDO get(Long id){
        Template template = templateRepository.getOne(id);
        return templateConverter.toTemplateDO(template);
    }

    private void checkParam(TemplateDO templateDO){
        Assert.notNull(templateDO.getCode(),"模版编码不能为空");
        Assert.notNull(templateDO.getName(),"模版名称不能为空");
    }

    public List<TemplateDO> getAll(){
        List<Template> templates = templateRepository.findAll();
        return templateConverter.toTemplateDOs(templates);
    }


}
