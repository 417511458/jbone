package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.CategoryRequestDO;
import cn.jbone.cms.common.dataobject.PagedResponseDO;
import cn.jbone.cms.common.enums.CategoryTypeEnum;
import cn.jbone.cms.core.converter.CategoryConverter;
import cn.jbone.cms.core.converter.CategoryFieldConfig;
import cn.jbone.cms.core.dao.entity.Category;
import cn.jbone.cms.core.dao.repository.CategoryRepository;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.exception.ObjectNotFoundException;
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
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConverter categoryConverter;

    /**
     * 获取栏目树
     * @return
     */
    public List<CategoryDO> getCategoryTree(){
        return getCategoryByPid(0l);
    }

    private List<CategoryDO> getCategoryByPid(Long pid){
        List<Category> categories = categoryRepository.findAllByPidOrderByOrders(pid);
        List<CategoryDO> categoryDOS = categoryConverter.toCategoryDOs(categories, CategoryFieldConfig.build());
        if(!CollectionUtils.isEmpty(categoryDOS)){
            for (CategoryDO categoryDO : categoryDOS){
                categoryDO.setChildren(getCategoryByPid(categoryDO.getId()));
            }
        }
        return categoryDOS;
    }

    /**
     * 根据查询条件获取栏目树
     * @param categoryRequestDO
     * @return
     */
    public List<CategoryDO> requestCategorysTree(CategoryRequestDO categoryRequestDO){
        return requestCategorysTree(categoryRequestDO.getPid(),categoryRequestDO);
    }

    private List<CategoryDO> requestCategorysTree(Long pid,CategoryRequestDO categoryRequestDO){
        List<Category> categories = categoryRepository.findAllByPidAndStatusAndInMenuOrderByOrders(pid,categoryRequestDO.getStatus(),categoryRequestDO.getInMenu());
        List<CategoryDO> categoryDOS = categoryConverter.toCategoryDOs(categories, CategoryFieldConfig.buildSimple());
        if(!CollectionUtils.isEmpty(categoryDOS)){
            for (CategoryDO categoryDO : categoryDOS){
                categoryDO.setChildren(requestCategorysTree(categoryDO.getId(),categoryRequestDO));
            }
        }
        return categoryDOS;
    }

    public CategoryDO get(Long id){
        Category category = categoryRepository.getOne(id);
        return categoryConverter.toCategoryDO(category,CategoryFieldConfig.build());
    }

    public void delete(Long id){

        long categoryCount = categoryRepository.countById(id);
        if(categoryCount <= 0){
            throw new ObjectNotFoundException("栏目不存在.");
        }

        long childCount = categoryRepository.countByPid(id);
        if(childCount > 0){
            throw new JboneException("含有子栏目，不能删除.");
        }

        categoryRepository.deleteById(id);

    }

    /**
     * 添加文章
     * @param categoryDO
     */
    public void addOrUpdate(CategoryDO categoryDO){

        checkParam(categoryDO);

        //如果是更新，先补下默认属性

        Category category = categoryConverter.toCategory(categoryDO);
        categoryRepository.save(category);
    }

    private void checkParam(CategoryDO categoryDO){
        Assert.notNull(categoryDO.getTitle());
    }


    /**
     * 请求分类列表
     * @param categoryRequestDO
     * @return
     */
    public PagedResponseDO<CategoryDO> requestCategorys(CategoryRequestDO categoryRequestDO){
        PageRequest pageRequest = null;
        if(StringUtils.isNotBlank(categoryRequestDO.getSortName())){
            pageRequest = PageRequest.of(categoryRequestDO.getPageNumber()-1,categoryRequestDO.getPageSize(), Sort.Direction.fromString(categoryRequestDO.getSortOrder()),categoryRequestDO.getSortName());
        }else {
            pageRequest = PageRequest.of(categoryRequestDO.getPageNumber()-1,categoryRequestDO.getPageSize());
        }

        Page<Category> articlePage =  categoryRepository.findAll(new CategoryCommonRequestSpecification(categoryRequestDO),pageRequest);

        PagedResponseDO<CategoryDO> responseDO = new PagedResponseDO<>();
        responseDO.setTotal(articlePage.getTotalElements());
        responseDO.setPageNum(articlePage.getNumber() + 1);
        responseDO.setPageSize(articlePage.getSize());
        responseDO.setDatas(categoryConverter.toCategoryDOs(articlePage.getContent(),CategoryFieldConfig.buildSimple()));

        return responseDO;
    }

    /**
     * 分类模糊查询
     */
    private class CategoryCommonRequestSpecification implements Specification<Category> {
        private CategoryRequestDO categoryRequestDO;
        public CategoryCommonRequestSpecification(CategoryRequestDO categoryRequestDO){
            this.categoryRequestDO = categoryRequestDO;
        }

        @Override
        public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if(categoryRequestDO == null){
                return criteriaQuery.getRestriction();
            }
            List<Predicate> predicates = new ArrayList<>();

            if(StringUtils.isNotBlank(categoryRequestDO.getTitle())){
                Path<String> title = root.get("title");
                predicates.add(criteriaBuilder.like(title,"%" + categoryRequestDO.getTitle() + "%"));
            }

            if(categoryRequestDO.getType() != null){
                Path<CategoryTypeEnum> type = root.get("type");
                predicates.add(criteriaBuilder.equal(type,categoryRequestDO.getType()));
            }

            Predicate predicate = criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
            return predicate;
        }
    }
}
