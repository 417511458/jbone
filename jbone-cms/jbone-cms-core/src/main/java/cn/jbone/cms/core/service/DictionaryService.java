package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.DictionaryGroupDO;
import cn.jbone.cms.common.dataobject.search.DictionaryGroupSearchDO;
import cn.jbone.cms.core.converter.DictionaryConverter;
import cn.jbone.cms.core.dao.entity.DictionaryItem;
import cn.jbone.cms.core.dao.entity.DictionaryGroup;
import cn.jbone.cms.core.dao.repository.DictionaryItemRepository;
import cn.jbone.cms.core.dao.repository.DictionaryGroupRepository;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.utils.SpecificationUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DictionaryService {
    @Autowired
    private DictionaryGroupRepository dictionaryGroupRepository;

    @Autowired
    private DictionaryItemRepository dictionaryItemRepository;

    @Autowired
    private DictionaryConverter dictionaryConverter;

    public void addOrUpdateGroup(DictionaryGroupDO groupDO){
        DictionaryGroup group = dictionaryConverter.toDictionaryGroup(groupDO);
        dictionaryGroupRepository.save(group);
    }

    public void deleteGroup(Integer groupId){
        DictionaryGroup group = dictionaryGroupRepository.getOne(groupId);
        if(group == null){
            throw new JboneException("字典组不存在");
        }
        if(dictionaryItemRepository.existsByGroup(group)){
            throw new JboneException("包含字典项，不能删除.");
        }
        dictionaryGroupRepository.delete(group);
    }

    public DictionaryGroupDO getGroup(Integer groupId){
        DictionaryGroup group = dictionaryGroupRepository.getOne(groupId);
        if(group == null){
            throw new JboneException("字典组不存在");
        }
        return dictionaryConverter.toDictionaryGroupDO(group);
    }

    public DictionaryItemDO getItem(Integer id){
        DictionaryItem item = dictionaryItemRepository.getOne(id);
        if(item == null){
            throw new JboneException("字典组不存在");
        }
        return dictionaryConverter.toDictionaryItemDO(item);
    }

    public List<DictionaryItemDO> getItems(Integer groupId){
        DictionaryGroup group = dictionaryGroupRepository.getOne(groupId);
        if(group == null){
            return null;
        }
        return dictionaryConverter.toDictionaryItemDOs(group.getItems());
    }
    public List<DictionaryItemDO> getItemsByGroupCode(String code){
        DictionaryGroup group = dictionaryGroupRepository.findByCode(code);
        if(group == null){
            return null;
        }
        return dictionaryConverter.toDictionaryItemDOs(group.getItems());
    }

    public Map<String,DictionaryItemDO> getItemsMapByGroupCode(String code){
        DictionaryGroup group = dictionaryGroupRepository.findByCode(code);
        if(group == null){
            return null;
        }
        List<DictionaryItemDO> list = dictionaryConverter.toDictionaryItemDOs(group.getItems());
        Map<String,DictionaryItemDO> map = new HashMap<>();
        if(!CollectionUtils.isEmpty(list)){
            for (DictionaryItemDO itemDO : list){
                map.put(itemDO.getDictValue(),itemDO);
            }
        }
        return map;
    }
    public void addOrUpdateItem(DictionaryItemDO itemDO){
        DictionaryItem item = dictionaryConverter.toDictionaryItem(itemDO);
        dictionaryItemRepository.save(item);
    }

    public void deleteItem(Integer id){
        DictionaryItem item = dictionaryItemRepository.getOne(id);
        if(item == null){
            throw new JboneException("字典不存在");
        }
        dictionaryItemRepository.delete(item);
    }



    public PagedResponseDO<DictionaryGroupDO> requestGroup(DictionaryGroupSearchDO requestDO){
        Sort sort = SpecificationUtils.buildSort(requestDO.getSorts());
        PageRequest pageRequest = PageRequest.of(requestDO.getPageNumber()-1, requestDO.getPageSize(),sort);
        Page<DictionaryGroup> pageResult =  dictionaryGroupRepository.findAll(new DictionaryGroupCommonRequestSpecification(requestDO),pageRequest);

        PagedResponseDO<DictionaryGroupDO> responseDO = new PagedResponseDO<>();
        responseDO.setTotal(pageResult.getTotalElements());
        responseDO.setPageNum(pageResult.getNumber() + 1);
        responseDO.setPageSize(pageResult.getSize());
        responseDO.setDatas(dictionaryConverter.toDictionaryGroupDOs(pageResult.getContent()));

        return responseDO;
    }




    private class DictionaryGroupCommonRequestSpecification implements Specification<DictionaryGroup> {
        DictionaryGroupSearchDO dictionaryGroupSearchDO;
        public DictionaryGroupCommonRequestSpecification(DictionaryGroupSearchDO dictionaryGroupSearchDO){
            this.dictionaryGroupSearchDO = dictionaryGroupSearchDO;
        }

        @Override
        public Predicate toPredicate(Root<DictionaryGroup> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(dictionaryGroupSearchDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();


            if(StringUtils.isNotBlank(dictionaryGroupSearchDO.getCode())){
                Path<String> code = root.get("code");
                predicates.add(criteriaBuilder.like(code,"%" + dictionaryGroupSearchDO.getCode() + "%"));
            }


            if(StringUtils.isNotBlank(dictionaryGroupSearchDO.getName())){
                Path<String> name = root.get("name");
                predicates.add(criteriaBuilder.like(name,"%" + dictionaryGroupSearchDO.getName() + "%"));
            }

            //补充条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder, dictionaryGroupSearchDO.getConditions());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }

}
