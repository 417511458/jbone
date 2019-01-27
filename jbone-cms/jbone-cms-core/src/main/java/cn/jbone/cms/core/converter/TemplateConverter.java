package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.core.dao.entity.Template;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TemplateConverter {

    public TemplateDO toTemplateDO(Template template){
        if(template == null){
            return null;
        }
        TemplateDO templateDO = new TemplateDO();

        BeanUtils.copyProperties(template,templateDO);

        return templateDO;
    }

    public Template toTemplate(TemplateDO templateDO){
        if(templateDO == null){
            return null;
        }
        Template template = new Template();

        BeanUtils.copyProperties(templateDO,template);

        return template;
    }
}
