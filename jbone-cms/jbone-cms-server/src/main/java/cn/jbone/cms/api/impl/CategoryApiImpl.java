package cn.jbone.cms.api.impl;


import cn.jbone.cms.api.CategoryApi;
import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.search.CategorySearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.cms.core.service.CategoryService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.exception.ObjectNotFoundException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryApiImpl implements CategoryApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryService categoryService;

    public Result<Void> addOrUpdate(@RequestBody CategoryDO categoryDO, @RequestHeader("userId") Integer userId){
        try {
            categoryDO.setCreator(userId);
            categoryService.addOrUpdate(categoryDO);
        } catch (JboneException e){
            logger.warn("delete error",e);
            return Result.wrap500Error(e.getMessage());
        }  catch (Exception e) {
            logger.error("category addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    public Result<Void> delete(Long id, @RequestHeader("userId") Integer userId){
        try {
            categoryService.delete(id,userId);
        } catch (JboneException e){
            logger.warn("delete error",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("category delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<CategoryDO> get(Long id) {
        CategoryDO categoryDO = null;
        try {
            categoryDO = categoryService.get(id);
        } catch (JboneException e){
            logger.warn("get error",e);
            return Result.wrap500Error(e.getMessage());
        }  catch (Exception e) {
            logger.error("category get error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(categoryDO);
    }

    public Result<List<CategoryDO>> getCategoryTree(Integer siteId){
        List<CategoryDO> categoryDOS = null;
        try {
            categoryDOS = categoryService.getCategoryTree(siteId);
        } catch (JboneException e){
            logger.warn("getCategoryTree error ",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("category getCategoryTree error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(categoryDOS);
    }

    @RequestMapping(value = "/requestCategorysTree", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<List<CategoryDO>> requestCategorysTree(@RequestBody CategorySearchDO categorySearchDO) {
        List<CategoryDO> categoryDOS = null;
        try {
            categoryDOS = categoryService.requestCategorysTree(categorySearchDO);
        } catch (JboneException e){
            logger.warn("requestCategorysTree error ",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("category requestCategorysTree error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(categoryDOS);
    }

    @Override
    public Result<PagedResponseDO<CategoryDO>> requestCategorys(@RequestBody CategorySearchDO categorySearchDO) {
        PagedResponseDO<CategoryDO> pagedResponseDO = null;
        try {
            pagedResponseDO = categoryService.requestCategorys(categorySearchDO);
        } catch (JboneException e){
            logger.warn("requestCategorys error ",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("category requestCategorys error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(pagedResponseDO);
    }
}
