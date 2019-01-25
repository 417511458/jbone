package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.core.converter.CategoryConverter;
import cn.jbone.cms.core.converter.CategoryFieldConfig;
import cn.jbone.cms.core.dao.entity.Category;
import cn.jbone.cms.core.dao.repository.CategoryRepository;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.exception.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

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
        List<Category> categories = categoryRepository.findAllByPid(pid);
        List<CategoryDO> categoryDOS = categoryConverter.toCategoryDOs(categories, CategoryFieldConfig.build());
        if(!CollectionUtils.isEmpty(categoryDOS)){
            for (CategoryDO categoryDO : categoryDOS){
                categoryDO.setChildCategory(getCategoryByPid(categoryDO.getId()));
            }
        }
        return categoryDOS;
    }

    public void delete(Long id){
        Category category = null;
        logger.info("ttttttt",category);
        try {
            category = categoryRepository.getOne(id);
        } catch (Exception e) {
            logger.warn(e.getMessage(),e);
            throw new ObjectNotFoundException("栏目不存在.");
        }
        logger.info("dddddddddddd",category);
        long childCount = categoryRepository.countByPid(id);
        if(childCount > 0){
            throw new JboneException("含有子栏目，不能删除.");
        }

        categoryRepository.delete(category);

    }

    /**
     * 添加文章
     * @param categoryDO
     */
    public void addOrUpdate(CategoryDO categoryDO){

        checkParam(categoryDO);

        Category category = categoryConverter.toCategory(categoryDO);
        categoryRepository.save(category);
    }

    private void checkParam(CategoryDO categoryDO){
        Assert.notNull(categoryDO.getTitle());
    }
}
