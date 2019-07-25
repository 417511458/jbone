package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.config.CategoryFieldConfigDO;
import cn.jbone.cms.core.dao.entity.Category;
import cn.jbone.cms.core.dao.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {

    @Autowired
    private TagConverter tagConverter;

    @Autowired
    private TemplateConverter templateConverter;

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDO toCategoryDO(Category category, CategoryFieldConfigDO config){
        if(category == null){
            return null;
        }

        CategoryDO categoryDO = new CategoryDO();

        categoryDO.setDescription(category.getDescription());
        categoryDO.setFrontCover(category.getFrontCover());
        categoryDO.setId(category.getId());
        categoryDO.setInMenu(category.getInMenu());
        categoryDO.setKeywords(category.getKeywords());
        categoryDO.setOrders(category.getOrders());
        categoryDO.setPid(category.getPid());
        categoryDO.setStatus(category.getStatus());

        categoryDO.setTarget(category.getTarget());

        categoryDO.setTitle(category.getTitle());
        categoryDO.setType(category.getType());
        categoryDO.setUrl(category.getUrl());
        categoryDO.setShowType(category.getShowType());
        categoryDO.setSiteId(category.getSiteId());
        categoryDO.setCode(category.getCode());

        if(config.isIncludeTag()){
            categoryDO.setTags(tagConverter.toTagDOs(category.getTags()));
        }
        if(config.isIncludeTemplate()){
            categoryDO.setTemplate(templateConverter.toTemplateDO(category.getTemplate()));
        }
        if(config.isIncludeChilds()){
            categoryDO.setChildren(toCategoryDOs(category.getChildCategory(),config));
        }

        return categoryDO;
    }

    public List<CategoryDO> toCategoryDOs(List<Category> categorys,CategoryFieldConfigDO config){
        if(CollectionUtils.isEmpty(categorys)){
            return null;
        }

        List<CategoryDO> categoryDOS = new ArrayList<>();
        for (Category category:categorys){
            CategoryDO categoryDO = toCategoryDO(category,config);
            if(categoryDO != null){
                categoryDOS.add(categoryDO);
            }
        }
        return categoryDOS;
    }

    public Category toCategory(CategoryDO categoryDO){
        if(categoryDO == null){
            return null;
        }

        Category category = null;
        if(categoryDO.getId() != null && categoryDO.getId() > 0){
            category = categoryRepository.getOne(categoryDO.getId());
        }
        if(category == null){
            category = new Category();
        }

        category.setDescription(categoryDO.getDescription());
        category.setFrontCover(categoryDO.getFrontCover());
        category.setId(categoryDO.getId());
        category.setInMenu(categoryDO.getInMenu());
        category.setKeywords(categoryDO.getKeywords());
        category.setOrders(categoryDO.getOrders());
        category.setPid(categoryDO.getPid());
        category.setStatus(categoryDO.getStatus());
        category.setTarget(categoryDO.getTarget());
        category.setTitle(categoryDO.getTitle());
        category.setType(categoryDO.getType());
        category.setUrl(categoryDO.getUrl());
        category.setShowType(categoryDO.getShowType());
        category.setSiteId(categoryDO.getSiteId());
        category.setCode(categoryDO.getCode());

        category.setTags(tagConverter.toTags(categoryDO.getTags()));
        category.setTemplate(templateConverter.toTemplate(categoryDO.getTemplate()));

        return category;
    }

    public List<Category> toCategories(List<CategoryDO> categoryDOS){
        if(CollectionUtils.isEmpty(categoryDOS)){
            return null;
        }

        List<Category> categories = new ArrayList<>();
        for (CategoryDO categoryDO:categoryDOS){
            Category category = toCategory(categoryDO);
            if(category != null){
                categories.add(category);
            }
        }
        return categories;
    }

}
