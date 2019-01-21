package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.module.article.TemplateDO;
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
}
