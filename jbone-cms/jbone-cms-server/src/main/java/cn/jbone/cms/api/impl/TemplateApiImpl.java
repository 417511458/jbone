package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.TemplateApi;
import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.core.service.TemplateService;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateApiImpl implements TemplateApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TemplateService templateService;

    @Override
    public Result<Void> addOrUpdate(@RequestBody TemplateDO templateDO) {
        try {
            templateService.addOrUpdate(templateDO);
        } catch (Exception e) {
            logger.warn("Template addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            templateService.delete(id);
        } catch (Exception e) {
            logger.warn("Template delete error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<TemplateDO> get(Long id) {
        TemplateDO templateDO = null;
        try {
            templateDO = templateService.get(id);
        } catch (Exception e) {
            logger.warn("Template get error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(templateDO);
    }

    @Override
    public Result<List<TemplateDO>> getAll() {
        List<TemplateDO> list;
        try {
            list = templateService.getAll();
        } catch (Exception e) {
            logger.warn("Template getAll error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(list);
    }
}
