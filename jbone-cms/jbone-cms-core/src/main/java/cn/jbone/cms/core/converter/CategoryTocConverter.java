package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.config.CategoryFieldConfigDO;
import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.core.dao.entity.CategoryToc;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.CategoryRepository;
import cn.jbone.cms.core.dao.repository.CategoryTocRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryTocConverter {

    @Autowired
    ArticleConverter articleConverter;
    @Autowired
    CategoryConverter categoryConverter;
    @Autowired
    CategoryTocRepository categoryTocRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ArticleRepository articleRepository;

    public CategoryTocDO toCategoryTocDO(CategoryToc categoryToc){
        if(categoryToc == null){
            return null;
        }

        CategoryTocDO categoryTocDO = new CategoryTocDO();
        BeanUtils.copyProperties(categoryToc,categoryTocDO,"childCategoryToc","category","article");

        categoryTocDO.setArticle(articleConverter.toBaseArticleDO(categoryToc.getArticle()));
        categoryTocDO.setCategory(categoryConverter.toCategoryDO(categoryToc.getCategory(), CategoryFieldConfigDO.build()));
        categoryTocDO.setChildren(toCategoryTocDOs(categoryToc.getChildCategoryToc()));

        return categoryTocDO;
    }

    public List<CategoryTocDO> toCategoryTocDOs(List<CategoryToc> categoryTocs){
        if(CollectionUtils.isEmpty(categoryTocs)){
            return null;
        }

        List<CategoryTocDO> list = new ArrayList<>();
        for (CategoryToc categoryToc : categoryTocs){
            CategoryTocDO categoryTocDO = toCategoryTocDO(categoryToc);
            if(categoryTocDO != null){
                list.add(categoryTocDO);
            }
        }
        return list;
    }

    public CategoryToc toCategoryToc(CategoryTocDO categoryTocDO){
        if(categoryTocDO == null){
            return null;
        }


        CategoryToc categoryToc = null;
        if(categoryTocDO.getId() != null && categoryTocDO.getId() > 0){
            categoryToc = categoryTocRepository.getOne(categoryTocDO.getId());
        }

        if(categoryToc == null){
            categoryToc = new CategoryToc();
        }
        if(categoryTocDO.getArticle() != null && categoryTocDO.getArticle().getId() != null && categoryTocDO.getArticle().getId() > 0){
            categoryToc.setArticle(articleRepository.getOne(categoryTocDO.getArticle().getId()));
        }
        if(categoryTocDO.getCategory() != null && categoryTocDO.getCategory().getId() != null && categoryTocDO.getCategory().getId() > 0){
            categoryToc.setCategory(categoryRepository.getOne(categoryTocDO.getCategory().getId()));
        }

        categoryToc.setFrontCover(categoryTocDO.getFrontCover());
        categoryToc.setOrders(categoryTocDO.getOrders());
        categoryToc.setPid(categoryTocDO.getPid());
        categoryToc.setTarget(categoryTocDO.getTarget());
        categoryToc.setTitle(categoryTocDO.getTitle());
        categoryToc.setUrl(categoryTocDO.getUrl());

        return categoryToc;
    }

    public List<CategoryToc> toCategoryTocs(List<CategoryTocDO> categoryTocDOs){
        if(CollectionUtils.isEmpty(categoryTocDOs)){
            return null;
        }
        List<CategoryToc> list = new ArrayList<>();
        for (CategoryTocDO categoryTocDO : categoryTocDOs){
            CategoryToc categoryToc = toCategoryToc(categoryTocDO);
            if(categoryToc != null){
                list.add(categoryToc);
            }
        }
        return list;
    }
}
