package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.common.dataobject.search.TemplateSearchDO;
import cn.jbone.cms.core.converter.TemplateConverter;
import cn.jbone.cms.core.dao.entity.Template;
import cn.jbone.cms.core.dao.repository.TemplateRepository;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.utils.SpecificationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private TemplateConverter templateConverter;
    @Autowired
    private TemplateRepository templateRepository;

    public void delete(Long id){
        if(!templateRepository.existsById(id)){
            throw new JboneException("模版不存在");
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
        try {
            Assert.notNull(templateDO.getCode(),"模版编码不能为空");
            Assert.notNull(templateDO.getName(),"模版名称不能为空");
            Assert.notNull(templateDO.getCreator(),"模版作者不能为空");
        } catch (Exception e) {
            logger.error("校验参数错误",e);
            throw new JboneException(e.getMessage());
        }
    }

    public PagedResponseDO<TemplateDO> commonRequest(TemplateSearchDO templateSearchDO){
        Sort sort = SpecificationUtils.buildSort(templateSearchDO.getSorts());
        PageRequest pageRequest = PageRequest.of(templateSearchDO.getPageNumber()-1, templateSearchDO.getPageSize(),sort);
        Page<Template> templatePage =  templateRepository.findAll(new TemplateCommonRequestSpecification(templateSearchDO),pageRequest);

        PagedResponseDO<TemplateDO> responseDO = new PagedResponseDO<>();
        responseDO.setTotal(templatePage.getTotalElements());
        responseDO.setPageNum(templatePage.getNumber() + 1);
        responseDO.setPageSize(templatePage.getSize());


        List<TemplateDO> datas = templateConverter.toTemplateDOs(templatePage.getContent());
        responseDO.setDatas(datas);

        return responseDO;
    }


    private class TemplateCommonRequestSpecification implements Specification<Template> {
        TemplateSearchDO templateSearchDO;
        public TemplateCommonRequestSpecification(TemplateSearchDO templateSearchDO){
            this.templateSearchDO = templateSearchDO;
        }

        @Override
        public Predicate toPredicate(Root<Template> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(templateSearchDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();


            if(StringUtils.isNotBlank(templateSearchDO.getCode())){
                Path<String> code = root.get("code");
                predicates.add(criteriaBuilder.equal(code,templateSearchDO.getCode()));
            }

            if(StringUtils.isNotBlank(templateSearchDO.getName())){
                Path<String> name = root.get("name");
                predicates.add(criteriaBuilder.like(name,"%" + templateSearchDO.getName() + "%"));
            }

            if(StringUtils.isNotBlank(templateSearchDO.getType())){
                Path<String> type = root.get("type");
                predicates.add(criteriaBuilder.equal(type,templateSearchDO.getType()));
            }

            if(templateSearchDO.getId() != null && templateSearchDO.getId() > 0){
                Path<Long> id = root.get("id");
                predicates.add(criteriaBuilder.equal(id,templateSearchDO.getId()));
            }

            if(templateSearchDO.getEnable() >= 0){
                Path<Integer> enable = root.get("enable");
                predicates.add(criteriaBuilder.equal(enable,templateSearchDO.getEnable()));
            }

            //补充条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder, templateSearchDO.getConditions());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }

}
