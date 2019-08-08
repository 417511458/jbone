package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.BatchSaveSiteSettingDO;
import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.cms.common.dataobject.SiteSettingsDO;
import cn.jbone.cms.common.dataobject.search.SiteSearchDO;
import cn.jbone.cms.common.dataobject.search.SiteSettingsSearchDO;
import cn.jbone.cms.core.converter.SiteSettingsConverter;
import cn.jbone.cms.core.dao.entity.Site;
import cn.jbone.cms.core.dao.entity.SiteSettings;
import cn.jbone.cms.core.dao.repository.SiteRepository;
import cn.jbone.cms.core.dao.repository.SiteSettingsRepository;
import cn.jbone.cms.core.validator.ContentValidator;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.utils.SpecificationUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SiteSettingsService {

    @Autowired
    private SiteSettingsRepository siteSettingsRepository;
    @Autowired
    private SiteSettingsConverter siteSettingsConverter;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private ContentValidator contentValidator;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public Map<String, String> getSettingsMap(Integer siteId){
        if(siteId == null || siteId <= 0){
            throw new JboneException("参数错误");
        }
        Map<String, String> settingsMap = new HashMap<>();
        List<SiteSettings> settingsList = siteSettingsRepository.findBySiteId(siteId);
        if(!CollectionUtils.isEmpty(settingsList)){
            for (SiteSettings settings : settingsList){
                settingsMap.put(settings.getName(),settings.getValue());
            }
        }
        return settingsMap;
    }

    public List<SiteSettingsDO> getSettingsList(Integer siteId){
        if(siteId == null || siteId <= 0){
            throw new JboneException("参数错误");
        }
        return siteSettingsConverter.toDOs(siteSettingsRepository.findBySiteId(siteId));
    }

    public void addOrUpdate(SiteSettingsDO settingsDO){
        if(settingsDO == null){
            throw new JboneException("参数错误");
        }

        contentValidator.checkPermition(settingsDO.getCreator(),settingsDO.getSiteId());

        try {
            siteSettingsRepository.save(siteSettingsConverter.toEntity(settingsDO));
        } catch (DataIntegrityViolationException e) {
            logger.warn("站点属性已存在",e);
            throw new JboneException("站点属性已存在");
        }
    }

    public void addOrUpdate(BatchSaveSiteSettingDO batchSaveSettingDO){
        if(CollectionUtils.isEmpty(batchSaveSettingDO.getSettingsList()) || batchSaveSettingDO.getSiteId() == null || batchSaveSettingDO.getSiteId() <= 0){
            throw new JboneException("参数错误");
        }
        if(!siteRepository.existsById(batchSaveSettingDO.getSiteId())){
            throw new JboneException("站点不存在");
        }
        contentValidator.checkPermition(batchSaveSettingDO.getUserId(),batchSaveSettingDO.getSiteId());
        List<SiteSettings> settingsList = siteSettingsConverter.toEntitys(batchSaveSettingDO.getSettingsList());
        List<SiteSettings> addOrUpdateList = new ArrayList<>();
        for (SiteSettings siteSettings : settingsList){
            siteSettings.setSiteId(batchSaveSettingDO.getSiteId());
            if(siteSettings.getId() == null || siteSettings.getId() <= 0){
                //如果存在name，则取原来的name，并设置新的value
                SiteSettings settings = siteSettingsRepository.findBySiteIdAndName(siteSettings.getSiteId(),siteSettings.getName());
                if(settings != null){
                    settings.setValue(siteSettings.getValue());
                    addOrUpdateList.add(settings);
                }else{
                    addOrUpdateList.add(siteSettings);
                }
            }else{
                addOrUpdateList.add(siteSettings);
            }

        }
        siteSettingsRepository.saveAll(addOrUpdateList);
    }

    public void delete(Long id,Integer userId){
        if(!siteSettingsRepository.existsById(id)){
            throw new JboneException("记录不存在");
        }
        SiteSettings siteSettings = siteSettingsRepository.getOne(id);
        contentValidator.checkPermition(userId,siteSettings.getSiteId());
        siteSettingsRepository.delete(siteSettings);
    }

    public SiteSettingsDO getById(Long id){
        if(!siteSettingsRepository.existsById(id)){
            throw new JboneException("记录不存在");
        }
        return siteSettingsConverter.toDO(siteSettingsRepository.getOne(id));
    }

    /**
     * 通用查询
     * @return
     */
    public PagedResponseDO<SiteSettingsDO> commonRequest(SiteSettingsSearchDO searchDO){
        PagedResponseDO<SiteSettingsDO> responseDO = new PagedResponseDO<>();

        Sort sort = SpecificationUtils.buildSort(searchDO.getSorts());
        PageRequest pageRequest = PageRequest.of(searchDO.getPageNumber()-1, searchDO.getPageSize(), sort);

        Page<SiteSettings> sitePage =  siteSettingsRepository.findAll(new SiteSettingsCommonRequestSpecification(searchDO),pageRequest);

        responseDO.setTotal(sitePage.getTotalElements());
        responseDO.setPageNum(sitePage.getNumber()+1);
        responseDO.setPageSize(sitePage.getSize());
        responseDO.setDatas(siteSettingsConverter.toDOs(sitePage.getContent()));
        return responseDO;

    }

    /**
     *
     */
    private class SiteSettingsCommonRequestSpecification implements Specification<SiteSettings> {
        private SiteSettingsSearchDO searchDO;
        public SiteSettingsCommonRequestSpecification(SiteSettingsSearchDO searchDO){
            this.searchDO = searchDO;
        }

        @Override
        public Predicate toPredicate(Root<SiteSettings> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(searchDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.isNotBlank(searchDO.getName())){
                Path<String> name = root.get("name");
                predicates.add(criteriaBuilder.like(name,"%" + searchDO.getName() + "%"));
            }

            if(searchDO.getSiteId() != null && searchDO.getSiteId() > 0){
                Path<Integer> siteId = root.get("siteId");
                predicates.add(criteriaBuilder.equal(siteId,searchDO.getSiteId()));
            }


            //补充条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder, searchDO.getConditions());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }


}
