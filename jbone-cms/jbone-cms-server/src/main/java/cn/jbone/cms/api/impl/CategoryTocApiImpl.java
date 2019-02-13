package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.CategoryTocApi;
import cn.jbone.cms.common.dataobject.CategoryTocDO;
import cn.jbone.cms.core.service.CategoryTocService;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryTocApiImpl implements CategoryTocApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CategoryTocService categoryTocService;

    @Override
    public Result<Void> addOrUpdate(@RequestBody CategoryTocDO categoryTocDO) {
        try {
            categoryTocService.addOrUpdate(categoryTocDO);
        } catch (Exception e) {
            logger.warn("CategoryToc addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            categoryTocService.delete(id);
        } catch (Exception e) {
            logger.warn("CategoryToc delete error.",e);
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
            logger.warn("CategoryToc getTree error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }
}
