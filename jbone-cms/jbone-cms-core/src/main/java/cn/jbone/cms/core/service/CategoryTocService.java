package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.ArticleRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.core.converter.CategoryTocConverter;
import cn.jbone.cms.core.dao.entity.Article;
import cn.jbone.cms.core.dao.entity.Category;
import cn.jbone.cms.core.dao.entity.CategoryToc;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.CategoryRepository;
import cn.jbone.cms.core.dao.repository.CategoryTocRepository;
import cn.jbone.common.exception.JboneException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

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
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleService articleService;

    public void delete(Long id){
        if(!categoryTocRepository.existsById(id)){
            throw new JboneException("目录不存在");
        }
        if(categoryTocRepository.countByPid(id) > 0){
            throw new JboneException("存在子目录，不能删除");
        }
        CategoryToc categoryToc = categoryTocRepository.getOne(id);
        categoryTocRepository.delete(categoryToc);
    }

    public CategoryTocDO get(Long id){
        CategoryToc categoryToc = categoryTocRepository.getOne(id);
        return categoryTocConverter.toCategoryTocDO(categoryToc);
    }

    public CategoryTocDO getByCategoryAndArticle(Long categoryId,Long articleId){
        Category category = categoryRepository.getOne(categoryId);
        if(category == null){
            return null;
        }
        Article article = articleRepository.getOne(articleId);
        if(article == null){
            return null;
        }
        List<CategoryToc> categoryTocs = categoryTocRepository.findAllByCategoryAndArticle(category,article);
        if(!CollectionUtils.isEmpty(categoryTocs)){
            return categoryTocConverter.toCategoryTocDO(categoryTocs.get(0));
        }
        return null;
    }


    public CategoryTocDO addOrUpdate(CategoryTocDO categoryTocDO){
        checkParam(categoryTocDO);
        CategoryToc categoryToc = categoryTocConverter.toCategoryToc(categoryTocDO);
        if(categoryTocDO.getArticle() != null){
            categoryTocDO.getArticle().setTitle(categoryTocDO.getTitle());

            ArticleRequestDO articleRequestDO = new ArticleRequestDO();
            BeanUtils.copyProperties(categoryTocDO.getArticle(),articleRequestDO);
            ArticleResponseDO articleResponseDo = articleService.addOrUpdateArticle(articleRequestDO);
            categoryToc.setArticle(articleRepository.getOne(articleResponseDo.getId()));
        }
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
