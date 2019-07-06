package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.core.converter.CategoryTocConverter;
import cn.jbone.cms.core.dao.entity.Category;
import cn.jbone.cms.core.dao.entity.CategoryToc;
import cn.jbone.cms.core.dao.repository.CategoryRepository;
import cn.jbone.cms.core.dao.repository.CategoryTocRepository;
import cn.jbone.common.exception.JboneException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;

@Service
public class CategoryTocService {
    @Autowired
    private CategoryTocConverter categoryTocConverter;
    @Autowired
    private CategoryTocRepository categoryTocRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void delete(Long id){
        if(!categoryTocRepository.existsById(id)){
            throw new JboneException("目录不存在");
        }
        if(categoryTocRepository.countByPid(id) > 0){
            throw new JboneException("存在子目录，不能删除");
        }

        categoryTocRepository.deleteById(id);
    }

    public CategoryTocDO get(Long id){
        CategoryToc categoryToc = categoryTocRepository.getOne(id);
        return categoryTocConverter.toCategoryTocDO(categoryToc);
    }


    public CategoryTocDO addOrUpdate(CategoryTocDO categoryTocDO){
        checkParam(categoryTocDO);
        CategoryToc categoryToc = categoryTocConverter.toCategoryToc(categoryTocDO);
        categoryTocRepository.save(categoryToc);
        return get(categoryToc.getId());
    }

    private void checkParam(CategoryTocDO categoryTocDO){
        Assert.notNull(categoryTocDO.getTitle(),"标题不能为空");
    }

    public List<CategoryTocDO> getTree(Long categoryId){
        Category category = categoryRepository.getOne(categoryId);
        if(category == null){
            return Collections.emptyList();
        }
        List<CategoryToc> categoryTocs = categoryTocRepository.findAllByCategoryAndPidOrderByOrders(category,0);
        return categoryTocConverter.toCategoryTocDOs(categoryTocs);
    }
}
