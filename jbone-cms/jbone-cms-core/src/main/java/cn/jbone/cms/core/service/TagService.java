package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.cms.common.dataobject.search.TagSearchDO;
import cn.jbone.cms.core.converter.TagConverter;
import cn.jbone.cms.core.dao.entity.Tag;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.TagRepository;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.ObjectNotFoundException;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagConverter tagConverter;

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * tag管理只有一个，就是查询所有的标签，并统计标签对应的文章数量
     * @return
     */
    public List<TagDO> findAll(){
        List<Tag> tags = tagRepository.findAll();
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

    public List<TagDO> getByName(String name){
        if(StringUtils.isBlank(name)){
            return findAll();
        }
        List<Tag> tags = tagRepository.findByNameContaining(name);
        return fillArticleCount(tags);
    }

    public void delete(Long id){
        if(!tagRepository.existsById(id)){
            throw new ObjectNotFoundException("标签不存在");
        }
        tagRepository.deleteById(id);
    }

    public void addOrUpdate(TagDO tagDO){
        Tag tag = tagConverter.toTag(tagDO);
        tagRepository.save(tag);
    }

    public TagDO getById(long id){
        Tag tag = tagRepository.getOne(id);
        return tagConverter.toTagDO(tag);
    }

    public List<TagDO> findTagCloud(){
        long count = tagRepository.articleTagCount();
        if(count <= 0){
            return null;
        }
        List<Tag> tagList = tagRepository.findTagCloud();
        return fillArticleCount(tagList);
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
