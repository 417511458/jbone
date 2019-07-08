package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.core.constants.ConverterConstants;
import cn.jbone.cms.core.dao.entity.Template;
import cn.jbone.cms.core.dao.repository.TemplateRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class TemplateConverter {

    @Autowired
    private TemplateRepository templateRepository;

    public TemplateDO toTemplateDO(Template template){
        if(template == null){
            return null;
        }
        TemplateDO templateDO = new TemplateDO();

        BeanUtils.copyProperties(template,templateDO);

        return templateDO;
    }

    public List<TemplateDO> toTemplateDOs(List<Template> templates){
        if(CollectionUtils.isEmpty(templates)){
            return null;
        }
        List<TemplateDO> list = new ArrayList<>();
        for (Template template : templates){
            TemplateDO templateDO = toTemplateDO(template);
            if(templateDO != null){
                list.add(templateDO);
            }
        }

        return list;
    }


    public Template toTemplate(TemplateDO templateDO){
        if(templateDO == null){
            return null;
        }
        Template template = null;
        if(templateDO.getId() != null && templateDO.getId() > 0){
            template = templateRepository.getOne(templateDO.getId());
        }
        if(template == null){
            template = new Template();
        }

        BeanUtils.copyProperties(templateDO,template, ConverterConstants.COPY_PROPERTIES_IGNORE);

        return template;
    }
}
