package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.CategoryTocApi;
import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.core.service.CategoryTocService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryTocApiImpl implements CategoryTocApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryTocService categoryTocService;

    @Override
    public Result<CategoryTocDO> get(Long id) {
        CategoryTocDO categoryTocDO = null;
        try{
            categoryTocDO = categoryTocService.get(id);
        }catch (JboneException e){
            logger.warn("CategoryToc get error.",e);
            return Result.wrap500Error(e.getMessage());
        }catch (Exception e){
            logger.warn("CategoryToc get error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(categoryTocDO);
    }

    @Override
    public Result<CategoryTocDO> getByCategoryAndArticle(Long categoryId, Long articleId) {
        CategoryTocDO categoryTocDO = null;
        try{
            categoryTocDO = categoryTocService.getByCategoryAndArticle(categoryId,articleId);
        }catch (JboneException e){
            logger.warn("CategoryToc getByCategoryAndArticle error.",e);
            return Result.wrap500Error(e.getMessage());
        }catch (Exception e){
            logger.warn("CategoryToc getByCategoryAndArticle error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(categoryTocDO);
    }

    @Override
    public Result<CategoryTocDO> addOrUpdate(@RequestBody CategoryTocDO categoryTocDO) {
        CategoryTocDO categoryToc = null;
        try {
            categoryToc = categoryTocService.addOrUpdate(categoryTocDO);
        } catch (JboneException e) {
            logger.warn("CategoryToc addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("CategoryToc addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(categoryToc);
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            categoryTocService.delete(id);
        } catch (JboneException e) {
            logger.warn("CategoryToc delete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("CategoryToc delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<List<CategoryTocDO>> getTree(Long categoryId) {
        List<CategoryTocDO> categoryTocDOs = null;
        try {
            categoryTocDOs = categoryTocService.getTree(categoryId);
        } catch (JboneException e) {
            logger.warn("CategoryToc getTree error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("CategoryToc getTree error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(categoryTocDOs);
    }
}
