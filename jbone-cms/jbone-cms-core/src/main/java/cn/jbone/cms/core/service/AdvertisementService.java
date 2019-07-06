package cn.jbone.cms.core.service;

import cn.jbone.cms.common.constant.DictionaryConstant;
import cn.jbone.cms.common.constant.SiteSettingConstant;
import cn.jbone.cms.common.dataobject.AdvertisementDO;
import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.PluginDO;
import cn.jbone.cms.common.dataobject.search.AdvertisementSearchDO;
import cn.jbone.cms.core.converter.AdvertisementConverter;
import cn.jbone.cms.core.converter.DictionaryConverter;
import cn.jbone.cms.core.dao.entity.Advertisement;
import cn.jbone.cms.core.dao.repository.AdvertisementRepository;
import cn.jbone.cms.core.validator.ContentValidator;
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
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AdvertisementService {
    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private AdvertisementConverter advertisementConverter;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private DictionaryConverter dictionaryConverter;

    @Autowired
    private ContentValidator contentValidator;

    @Autowired
    private SiteSettingsService siteSettingsService;

    Logger logger = LoggerFactory.getLogger(getClass());

    public AdvertisementDO get(Long id){
        Advertisement advertisement = advertisementRepository.getOne(id);
        if(advertisement == null){
            throw new JboneException("广告不存在");
        }
        return advertisementConverter.toDO(advertisement);
    }

    public void addOrUpdate(AdvertisementDO advertisementDO){

        contentValidator.checkPermition(advertisementDO.getCreator(),advertisementDO.getSiteId());

        checkLimit(advertisementDO);

        Advertisement advertisement = advertisementConverter.toEntity(advertisementDO);
        if(advertisement == null){
            throw new JboneException("广告不存在");
        }
        advertisementRepository.save(advertisement);
    }
    /**
     * 校验限额
     */
    private void checkLimit(AdvertisementDO advertisementDO){
        if(advertisementDO.getId() == null || advertisementDO.getId() <= 0){
            Map<String, String> settingMap = siteSettingsService.getSettingsMap(advertisementDO.getSiteId());
            if(!settingMap.containsKey(SiteSettingConstant.LIMIT_ADS_COUNT)){
                throw new JboneException("本站禁止添加广告，如有疑问请联系管理员.");
            }
            Long limitCount = Long.parseLong(settingMap.get(SiteSettingConstant.LIMIT_ADS_COUNT));
            if(limitCount <= 0){
                logger.warn("超出广告限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "个广告");
            }
            long currentCount = advertisementRepository.countBySiteId(advertisementDO.getSiteId());
            if(currentCount >= limitCount){
                logger.warn("超出广告限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "个广告");
            }
        }
    }

    public void delete(Long id,Integer userId){
        if(!advertisementRepository.existsById(id)){
            throw new JboneException("广告不存在");
        }

        Advertisement advertisement = advertisementRepository.getOne(id);
        contentValidator.checkPermition(userId,advertisement.getSiteId());

        advertisementRepository.deleteById(id);
    }

    public PagedResponseDO<AdvertisementDO> commonRequest(AdvertisementSearchDO advertisementSearchDO){
        Sort sort = SpecificationUtils.buildSort(advertisementSearchDO.getSorts());
        PageRequest pageRequest = PageRequest.of(advertisementSearchDO.getPageNumber()-1, advertisementSearchDO.getPageSize(),sort);
        Page<Advertisement> advertisementPage =  advertisementRepository.findAll(new AdvertisementCommonRequestSpecification(advertisementSearchDO),pageRequest);

        PagedResponseDO<AdvertisementDO> responseDO = new PagedResponseDO<>();
        responseDO.setTotal(advertisementPage.getTotalElements());
        responseDO.setPageNum(advertisementPage.getNumber() + 1);
        responseDO.setPageSize(advertisementPage.getSize());


        List<AdvertisementDO> datas = advertisementConverter.toDOS(advertisementPage.getContent());
        responseDO.setDatas(datas);

        fillLocationAndType(datas);

        return responseDO;
    }

    private void fillLocationAndType(List<AdvertisementDO> datas){
        if(!CollectionUtils.isEmpty(datas)){
            //拼接类型描述
            Map<String, DictionaryItemDO> locationMap = dictionaryService.getItemsMapByGroupCode(DictionaryConstant.GROUP_ADS_LOCATION);
            Map<String, DictionaryItemDO> typeMap = dictionaryService.getItemsMapByGroupCode(DictionaryConstant.GROUP_ADS_TYPE);

            if(!CollectionUtils.isEmpty(locationMap)){
                for (AdvertisementDO advertisementDO : datas){
                    if(StringUtils.isNotBlank(advertisementDO.getLocation())){
                        DictionaryItemDO dictionaryItemDO = locationMap.get(advertisementDO.getLocation());
                        if(dictionaryItemDO == null)continue;
                        advertisementDO.setLocationDetail(dictionaryConverter.toInnerDictionaryItemDO(dictionaryItemDO));
                    }
                }
            }
            if(!CollectionUtils.isEmpty(typeMap)){
                for (AdvertisementDO advertisementDO : datas){
                    if(StringUtils.isNotBlank(advertisementDO.getType())){
                        DictionaryItemDO dictionaryItemDO = typeMap.get(advertisementDO.getType());
                        if(dictionaryItemDO == null)continue;
                        advertisementDO.setTypeDetail(dictionaryConverter.toInnerDictionaryItemDO(dictionaryItemDO));
                    }
                }
            }
        }
    }

    public Map<String,List<AdvertisementDO>> findAllMap(){
        AdvertisementSearchDO advertisementSearchDO = new AdvertisementSearchDO();
        advertisementSearchDO.setEnable(1);
        List<Advertisement> list = advertisementRepository.findAll(new AdvertisementCommonRequestSpecification(advertisementSearchDO));
        return advertisementConverter.toDOSMap(list);
    }


    private class AdvertisementCommonRequestSpecification implements Specification<Advertisement> {
        AdvertisementSearchDO advertisementSearchDO;
        public AdvertisementCommonRequestSpecification(AdvertisementSearchDO advertisementSearchDO){
            this.advertisementSearchDO = advertisementSearchDO;
        }

        @Override
        public Predicate toPredicate(Root<Advertisement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(advertisementSearchDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();


            if(StringUtils.isNotBlank(advertisementSearchDO.getName())){
                Path<String> name = root.get("name");
                predicates.add(criteriaBuilder.like(name,"%" + advertisementSearchDO.getName() + "%"));
            }

            if(advertisementSearchDO.getSiteId() != null && advertisementSearchDO.getSiteId() > 0){
                Path<Integer> siteId = root.get("siteId");
                predicates.add(criteriaBuilder.equal(siteId,advertisementSearchDO.getSiteId()));
            }

            if(StringUtils.isNotBlank(advertisementSearchDO.getLocation())){
                Path<String> location = root.get("location");
                predicates.add(criteriaBuilder.equal(location,advertisementSearchDO.getLocation()));
            }

            if(StringUtils.isNotBlank(advertisementSearchDO.getType())){
                Path<String> type = root.get("type");
                predicates.add(criteriaBuilder.equal(type,advertisementSearchDO.getType()));
            }

            if(advertisementSearchDO.getId() != null && advertisementSearchDO.getId() > 0){
                Path<Long> id = root.get("id");
                predicates.add(criteriaBuilder.equal(id,advertisementSearchDO.getId()));
            }

            if(advertisementSearchDO.getEnable() > 0){
                Path<Integer> enable = root.get("enable");
                predicates.add(criteriaBuilder.equal(enable,advertisementSearchDO.getEnable()));
            }

            //补充条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder, advertisementSearchDO.getConditions());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }
}
