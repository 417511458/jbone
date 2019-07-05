package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.TagApi;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.cms.common.dataobject.search.TagSearchDO;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.cms.core.service.TagService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagApiImpl implements TagApi {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TagService tagService;

    @Override
    public Result<List<TagDO>> getAll(Integer siteId) {
        List<TagDO> tagDOS;
        try {
            tagDOS = tagService.findAll(siteId);
        } catch (JboneException e) {
            logger.warn("Tag getAll error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Tag getAll error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(tagDOS);
    }

    @Override
    public Result<List<TagDO>> findTagCloud(Integer siteId) {
        List<TagDO> tagDOS;
        try {
            tagDOS = tagService.findAll(siteId);
        } catch (JboneException e) {
            logger.warn("Tag findTagCloud error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Tag findTagCloud error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(tagDOS);
    }

    @Override
    public Result<List<TagDO>> getByName(String name,Integer siteId) {
        List<TagDO> tagDOS;
        try {
            tagDOS = tagService.getByName(name,siteId);
        } catch (JboneException e) {
            logger.warn("Tag getByName error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Tag getByName error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(tagDOS);
    }

    @Override
    public Result<TagDO> getById(Long id) {
        TagDO tagDO = null;
        try {
            tagDO = tagService.getById(id);
        } catch (JboneException e) {
            logger.warn("Tag getById error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Tag getById error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(tagDO);
    }

    @Override
    public Result<Void> delete(Long id,@RequestHeader("userId") Integer userId) {
        try {
            tagService.delete(id,userId);
        } catch (JboneException e) {
            logger.warn("Tag delete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Tag delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> addOrUpdate(@RequestBody TagDO tagDO,@RequestHeader("userId") Integer userId) {
        try {
            tagDO.setCreator(userId);
            tagService.addOrUpdate(tagDO);
        } catch (JboneException e) {
            logger.warn("Tag addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Tag addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<PagedResponseDO<TagDO>> commonRequest(@RequestBody TagSearchDO tagSearchDO) {
        PagedResponseDO<TagDO> pagedResponseDO = null;
        try {
            pagedResponseDO = tagService.commonRequest(tagSearchDO);
        } catch (JboneException e) {
            logger.warn("Tag commonRequest error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Tag commonRequest error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(pagedResponseDO);
    }
}
