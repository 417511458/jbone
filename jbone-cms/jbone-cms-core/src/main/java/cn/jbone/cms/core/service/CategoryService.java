package cn.jbone.cms.core.service;

import cn.jbone.cms.common.constant.SiteSettingConstant;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.config.CategoryFieldConfigDO;
import cn.jbone.cms.common.dataobject.search.CategorySearchDO;
import cn.jbone.cms.core.validator.ContentValidator;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.core.converter.CategoryConverter;
import cn.jbone.cms.core.dao.entity.Category;
import cn.jbone.cms.core.dao.repository.CategoryRepository;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.utils.SpecificationUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import java.util.Map;

@Service
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    @Autowired
    private ContentValidator contentValidator;

    @Autowired
    private SiteSettingsService siteSettingsService;

    /**
     * 获取栏目树
     * @return
     */
    public List<CategoryDO> getCategoryTree(Integer siteId){
        return getCategoryByPid(0l,siteId);
    }

    private List<CategoryDO> getCategoryByPid(Long pid,Integer siteId){
        List<Category> categories = categoryRepository.findAllByPidAndSiteIdOrderByOrders(pid,siteId);
        List<CategoryDO> categoryDOS = categoryConverter.toCategoryDOs(categories, CategoryFieldConfigDO.build());
        if(!CollectionUtils.isEmpty(categoryDOS)){
            for (CategoryDO categoryDO : categoryDOS){
                categoryDO.setChildren(getCategoryByPid(categoryDO.getId(),siteId));
            }
        }
        return categoryDOS;
    }

    /**
     * 根据查询条件获取栏目树
     * @param categorySearchDO
     * @return
     */
    public List<CategoryDO> requestCategorysTree(CategorySearchDO categorySearchDO){
        return requestCategorysTree(categorySearchDO.getPid(), categorySearchDO);
    }

    private List<CategoryDO> requestCategorysTree(Long pid, CategorySearchDO categorySearchDO){
        List<Category> categories = categoryRepository.findAllByPidAndStatusAndInMenuAndSiteIdOrderByOrders(pid, categorySearchDO.getStatus(), categorySearchDO.getInMenu(),categorySearchDO.getSiteId());
        List<CategoryDO> categoryDOS = categoryConverter.toCategoryDOs(categories, CategoryFieldConfigDO.build());
        if(!CollectionUtils.isEmpty(categoryDOS)){
            for (CategoryDO categoryDO : categoryDOS){
                categoryDO.setChildren(requestCategorysTree(categoryDO.getId(), categorySearchDO));
            }
        }
        return categoryDOS;
    }

    public CategoryDO get(Long id){
        Category category = categoryRepository.getOne(id);
        return categoryConverter.toCategoryDO(category,CategoryFieldConfigDO.buildAll());
    }

    public void delete(Long id,Integer userId){

        if(!categoryRepository.existsById(id)){
            throw new JboneException("栏目不存在.");
        }

        long childCount = categoryRepository.countByPid(id);
        if(childCount > 0){
            throw new JboneException("含有子栏目，不能删除.");
        }

        Category category = categoryRepository.getOne(id);

        contentValidator.checkPermition(userId,category.getSiteId());

        categoryRepository.deleteById(id);

    }

    /**
     * 添加文章
     * @param categoryDO
     */
    public void addOrUpdate(CategoryDO categoryDO){

        checkParam(categoryDO);

        contentValidator.checkPermition(categoryDO.getCreator(),categoryDO.getSiteId());

        checkLimit(categoryDO);

        try {
            Category category = categoryConverter.toCategory(categoryDO);
            categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            logger.warn("栏目编码已存在",e);
            throw new JboneException("栏目编码已存在");
        }
    }

    private void checkParam(CategoryDO categoryDO){
        Assert.notNull(categoryDO.getTitle());
    }

    /**
     * 校验限额
     */
    private void checkLimit(CategoryDO categoryDO){
        if(categoryDO.getId() == null || categoryDO.getId() <= 0){
            Map<String, String> settingMap = siteSettingsService.getSettingsMap(categoryDO.getSiteId());
            if(!settingMap.containsKey(SiteSettingConstant.LIMIT_CATEGORY_COUNT)){
                throw new JboneException("本站禁止添加栏目，如有疑问请联系管理员.");
            }
            Long limitCount = Long.parseLong(settingMap.get(SiteSettingConstant.LIMIT_CATEGORY_COUNT));
            if(limitCount <= 0){
                logger.warn("超出栏目限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "个栏目");
            }
            long currentCount = categoryRepository.countBySiteId(categoryDO.getSiteId());
            if(currentCount >= limitCount){
                logger.warn("超出栏目限额{}",limitCount);
                throw new JboneException("本站最多添加"+ limitCount + "个栏目");
            }
        }
    }

    /**
     * 请求分类列表
     * @param categorySearchDO
     * @return
     */
    public PagedResponseDO<CategoryDO> requestCategorys(CategorySearchDO categorySearchDO){
        PageRequest pageRequest = null;

        Sort sort = SpecificationUtils.buildSort(categorySearchDO.getSorts());
        pageRequest = PageRequest.of(categorySearchDO.getPageNumber()-1, categorySearchDO.getPageSize(), sort);

        Page<Category> articlePage =  categoryRepository.findAll(new CategoryCommonRequestSpecification(categorySearchDO),pageRequest);

        PagedResponseDO<CategoryDO> responseDO = new PagedResponseDO<>();
        responseDO.setTotal(articlePage.getTotalElements());
        responseDO.setPageNum(articlePage.getNumber() + 1);
        responseDO.setPageSize(articlePage.getSize());
        responseDO.setDatas(categoryConverter.toCategoryDOs(articlePage.getContent(), categorySearchDO.getConfig()));

        return responseDO;
    }

    /**
     * 分类模糊查询
     */
    private class CategoryCommonRequestSpecification implements Specification<Category> {
        private CategorySearchDO categorySearchDO;
        public CategoryCommonRequestSpecification(CategorySearchDO categorySearchDO){
            this.categorySearchDO = categorySearchDO;
        }

        @Override
        public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(categorySearchDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.isNotBlank(categorySearchDO.getCode())){
                Path<String> code = root.get("code");
                predicates.add(criteriaBuilder.equal(code,categorySearchDO.getCode()));
            }

            if(StringUtils.isNotBlank(categorySearchDO.getTitle())){
                Path<String> title = root.get("title");
                predicates.add(criteriaBuilder.like(title,"%" + categorySearchDO.getTitle() + "%"));
            }

            if(categorySearchDO.getSiteId() != null && categorySearchDO.getSiteId() > 0){
                Path<Integer> siteId = root.get("siteId");
                predicates.add(criteriaBuilder.equal(siteId,categorySearchDO.getSiteId()));
            }

            if(categorySearchDO.getType() != null){
                Path<CategoryTypeEnum> type = root.get("type");
                predicates.add(criteriaBuilder.equal(type, categorySearchDO.getType()));
            }

            //补充条件查询
            List<Predicate> conditionPredicats = SpecificationUtils.generatePredicates(root,criteriaBuilder, categorySearchDO.getConditions());
            if(!CollectionUtils.isEmpty(conditionPredicats)){
                predicates.addAll(conditionPredicats);
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }
}
