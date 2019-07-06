package cn.jbone.cms.core.service;

import cn.jbone.cms.common.constant.SiteSettingConstant;
import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.search.TagSearchDO;
import cn.jbone.cms.core.converter.TagConverter;
import cn.jbone.cms.core.dao.entity.Tag;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.TagRepository;
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
import java.util.*;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagConverter tagConverter;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ContentValidator contentValidator;

    @Autowired
    private SiteSettingsService siteSettingsService;

    Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * tag管理只有一个，就是查询所有的标签，并统计标签对应的文章数量
     * @return
     */
    public List<TagDO> findAll(Integer siteId){
        List<Tag> tags = tagRepository.findBySiteId(siteId);
        return fillArticleCount(tags);
    }

    private List<TagDO> fillArticleCount(List<Tag> tags){
        if(CollectionUtils.isEmpty(tags)){
            return null;
        }
        List<TagDO> tagDOS = new ArrayList<>();
        if(!CollectionUtils.isEmpty(tags)){
            for (Tag tag : tags){
                TagDO tagDO = tagConverter.toTagDO(tag);
                tagDO.setArticleCount(articleRepository.countByTags(Arrays.asList(tag)));
                tagDOS.add(tagDO);
            }
        }
        Collections.sort(tagDOS);
        return tagDOS;
    }

    public List<TagDO> getByName(String name,Integer siteId){
        if(StringUtils.isBlank(name)){
            return findAll(siteId);
        }
        List<Tag> tags = tagRepository.findByNameContainingAndSiteId(name,siteId);
        return fillArticleCount(tags);
    }

    public void delete(Long id,Integer userId){
        if(!tagRepository.existsById(id)){
            throw new JboneException("标签不存在");
        }

        Tag tag = tagRepository.getOne(id);

        contentValidator.checkPermition(userId,tag.getSiteId());

        tagRepository.delete(tag);
    }

    public void addOrUpdate(TagDO tagDO){
        contentValidator.checkPermition(tagDO.getCreator(),tagDO.getSiteId());
        checkLimit(tagDO);

        Tag tag = tagConverter.toTag(tagDO);
        tagRepository.save(tag);
    }

    /**
     * 校验限额
     */
    private void checkLimit(TagDO tagDO){
        if(tagDO.getId() == null || tagDO.getId() <= 0){
            Map<String, String> settingMap = siteSettingsService.getSettingsMap(tagDO.getSiteId());
            if(!settingMap.containsKey(SiteSettingConstant.LIMIT_TAG_COUNT)){
                throw new JboneException("本站禁止添加标签，如有疑问请联系管理员.");
            }
            Long limitCount = Long.parseLong(settingMap.get(SiteSettingConstant.LIMIT_TAG_COUNT));
            if(limitCount <= 0){
                logger.warn("超出标签限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "个标签");
            }
            long currentCount = tagRepository.countBySiteId(tagDO.getSiteId());
            if(currentCount >= limitCount){
                logger.warn("超出标签限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "个栏目");
            }
        }
    }

    public TagDO getById(long id){
        Tag tag = tagRepository.getOne(id);
        return tagConverter.toTagDO(tag);
    }

    /**
     * 通用查询
     * @return
     */
    public PagedResponseDO<TagDO> commonRequest(TagSearchDO tagSearchDO){
        PagedResponseDO<TagDO> responseDO = new PagedResponseDO<>();

        Sort sort = SpecificationUtils.buildSort(tagSearchDO.getSorts());
        PageRequest pageRequest = PageRequest.of(tagSearchDO.getPageNumber()-1, tagSearchDO.getPageSize(), sort);

        Page<Tag> tagPage =  tagRepository.findAll(new TagCommonRequestSpecification(tagSearchDO),pageRequest);

        responseDO.setTotal(tagPage.getTotalElements());
        responseDO.setPageNum(tagPage.getNumber()+1);
        responseDO.setPageSize(tagPage.getSize());
        if(tagSearchDO.isIncludeArticleCount()){
            responseDO.setDatas(fillArticleCount(tagPage.getContent()));
        }else{
            responseDO.setDatas(tagConverter.toTagDOs(tagPage.getContent()));
        }



        return responseDO;

    }

    /**
     *
     */
    private class TagCommonRequestSpecification implements Specification<Tag> {
        private TagSearchDO tagSearchDO;
        public TagCommonRequestSpecification(TagSearchDO tagSearchDO){
            this.tagSearchDO = tagSearchDO;
        }

        @Override
        public Predicate toPredicate(Root<Tag> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(tagSearchDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.isNotBlank(tagSearchDO.getName())){
                Path<String> name = root.get("name");
                predicates.add(criteriaBuilder.like(name,"%" + tagSearchDO.getName() + "%"));
            }

            if(tagSearchDO.getSiteId() != null && tagSearchDO.getSiteId() > 0){
                Path<Integer> siteId = root.get("siteId");
                predicates.add(criteriaBuilder.equal(siteId,tagSearchDO.getSiteId()));
            }

            //补充条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder, tagSearchDO.getConditions());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }
}
