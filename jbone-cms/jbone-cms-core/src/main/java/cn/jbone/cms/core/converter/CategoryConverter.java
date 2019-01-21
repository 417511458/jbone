package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.module.article.CategoryDO;
import cn.jbone.cms.core.dao.entity.Category;
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

    public CategoryDO toCategoryDO(Category category){
        if(category == null){
            return null;
        }

        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setChildCategory(toCategoryDOs(category.getChildCategory()));
        categoryDO.setDescription(category.getDescription());
        categoryDO.setFrontCover(category.getFrontCover());
        categoryDO.setId(category.getId());
        categoryDO.setInMenu(category.getInMenu());
        categoryDO.setKeywords(category.getKeywords());
        categoryDO.setOrders(category.getOrders());
        categoryDO.setPid(category.getPid());
        categoryDO.setStatus(category.getStatus());
        categoryDO.setTags(tagConverter.toTagDOs(category.getTags()));
        categoryDO.setTarget(category.getTarget());
        categoryDO.setTemplate(templateConverter.toTemplateDO(category.getTemplate()));
        categoryDO.setTitle(category.getTitle());
        categoryDO.setType(category.getType());
        categoryDO.setUrl(category.getUrl());

        return categoryDO;
    }

    public List<CategoryDO> toCategoryDOs(List<Category> categorys){
        if(CollectionUtils.isEmpty(categorys)){
            return null;
        }

        List<CategoryDO> categoryDOS = new ArrayList<>();
        for (Category category:categorys){
            CategoryDO categoryDO = toCategoryDO(category);
            if(categoryDO != null){
                categoryDOS.add(categoryDO);
            }
        }
        return categoryDOS;
    }
}
