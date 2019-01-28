package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.core.converter.CategoryTocConverter;
import cn.jbone.cms.core.dao.entity.Category;
import cn.jbone.cms.core.dao.entity.CategoryToc;
import cn.jbone.cms.core.dao.repository.CategoryTocRepository;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CategoryTocService {
    @Autowired
    private CategoryTocConverter categoryTocConverter;
    @Autowired
    private CategoryTocRepository categoryTocRepository;

    public void delete(Long id){
        if(!categoryTocRepository.existsById(id)){
            throw new ObjectNotFoundException("目录不存在");
        }
        if(categoryTocRepository.countByPid(id) > 0){
            throw new JboneException("存在子目录，不能删除");
        }

        categoryTocRepository.deleteById(id);
    }


    public void addOrUpdate(CategoryTocDO categoryTocDO){
        checkParam(categoryTocDO);
        CategoryToc categoryToc = categoryTocConverter.toCategoryToc(categoryTocDO);
        categoryTocRepository.save(categoryToc);
    }

    private void checkParam(CategoryTocDO categoryTocDO){
        Assert.notNull(categoryTocDO.getTitle(),"标题不能为空");
    }

    public CategoryTocDO getTree(Long categoryId){
        Category category = new Category();
        category.setId(categoryId);
        CategoryToc categoryToc = categoryTocRepository.findCategoryTocByCategory(category);
        return categoryTocConverter.toCategoryTocDO(categoryToc);
    }
}
