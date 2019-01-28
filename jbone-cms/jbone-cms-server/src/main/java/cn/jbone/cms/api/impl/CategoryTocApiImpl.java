package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.CategoryTocApi;
import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.core.service.CategoryTocService;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryTocApiImpl implements CategoryTocApi {
    @Autowired
    private CategoryTocService categoryTocService;

    @Override
    public Result<Void> addOrUpdate(CategoryTocDO categoryTocDO) {
        try {
            categoryTocService.addOrUpdate(categoryTocDO);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            categoryTocService.delete(id);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<CategoryTocDO> getTree(Long categoryId) {
        CategoryTocDO categoryTocDO = null;
        try {
            categoryTocDO = categoryTocService.getTree(categoryId);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }
}
