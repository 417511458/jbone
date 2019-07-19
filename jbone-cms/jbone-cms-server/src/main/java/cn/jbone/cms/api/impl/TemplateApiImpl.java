package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.TemplateApi;
import cn.jbone.cms.common.dataobject.TemplateDO;
import cn.jbone.cms.common.dataobject.search.TemplateSearchDO;
import cn.jbone.cms.core.service.TemplateService;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemplateApiImpl implements TemplateApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TemplateService templateService;

    @Override
    public Result<Void> addOrUpdate(@RequestBody TemplateDO templateDO,@RequestHeader("userId") Integer userId) {
        try {
            templateDO.setCreator(userId);
            templateService.addOrUpdate(templateDO);
        } catch (JboneException e) {
            logger.warn("Template addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Template addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id,@RequestHeader("userId") Integer userId) {
        try {
            templateService.delete(id);
        } catch (JboneException e) {
            logger.warn("Template delete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Template delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<TemplateDO> get(Long id) {
        TemplateDO templateDO = null;
        try {
            templateDO = templateService.get(id);
        } catch (JboneException e) {
            logger.warn("Template get error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Template get error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(templateDO);
    }

    @Override
    public Result<PagedResponseDO<TemplateDO>> commonRequest(@RequestBody TemplateSearchDO templateSearchDO) {
        logger.info("搜索模版:{}", JSON.toJSONString(templateSearchDO));
        PagedResponseDO<TemplateDO> pagedResponseDO = null;
        try {
            pagedResponseDO = templateService.commonRequest(templateSearchDO);
        } catch (JboneException e) {
            logger.warn("Template getAll error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Template getAll error.",e);
            return Result.wrap500Error("系统错误");
        }
        logger.info("搜索模版结果:{}", JSON.toJSONString(pagedResponseDO));
        return Result.wrapSuccess(pagedResponseDO);
    }
}
