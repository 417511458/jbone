package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.LinkApi;
import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.cms.core.service.LinkService;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinkApiImpl implements LinkApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LinkService linkService;

    @Override
    public Result<Void> addOrUpdate(@RequestBody LinkDO linkDO) {
        try {
            linkService.addOrUpdate(linkDO);
        } catch (Exception e) {
            logger.warn("Link addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            linkService.delete(id);
        } catch (Exception e) {
            logger.warn("Link delete error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> batchDelete(String ids) {
        try {
            linkService.batchDelete(ids);
        } catch (Exception e) {
            logger.warn("Link batchDelete error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<LinkDO> get(Long id) {
        LinkDO linkDO = null;
        try {
            linkDO = linkService.get(id);
        } catch (Exception e) {
            logger.warn("Link get error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(linkDO);
    }

    @Override
    public Result<List<LinkDO>> getAll() {
        List<LinkDO> linkDOS = null;
        try {
            linkDOS = linkService.getAll();
        } catch (Exception e) {
            logger.warn("Link getAll error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(linkDOS);
    }
}
