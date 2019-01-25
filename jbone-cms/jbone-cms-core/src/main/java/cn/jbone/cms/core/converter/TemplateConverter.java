package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.core.dao.entity.Template;
import org.springframework.stereotype.Component;

@Component
public class TemplateConverter {

    public TemplateDO toTemplateDO(Template template){
        if(template == null){
            return null;
        }
        TemplateDO templateDO = new TemplateDO();
        templateDO.setCode(template.getCode());
        templateDO.setDescription(template.getDescription());
        templateDO.setFrontCover(template.getFrontCover());
        templateDO.setId(template.getId());
        templateDO.setImages(template.getImages());
        templateDO.setName(template.getName());
        templateDO.setType(template.getType());

        return templateDO;
    }

    public Template toTemplate(TemplateDO templateDO){
        if(templateDO == null){
            return null;
        }
        Template template = new Template();
        template.setCode(templateDO.getCode());
        template.setDescription(templateDO.getDescription());
        template.setFrontCover(templateDO.getFrontCover());
        template.setId(templateDO.getId());
        template.setImages(templateDO.getImages());
        template.setName(templateDO.getName());
        template.setType(templateDO.getType());

        return template;
    }
}
