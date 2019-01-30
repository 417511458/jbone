package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.TagApi;
import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.cms.core.service.TagService;
import cn.jbone.common.rpc.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagApiImpl implements TagApi {

    @Autowired
    private TagService tagService;

    @Override
    public Result<List<TagDO>> getAll() {
        List<TagDO> tagDOS;
        try {
            tagDOS = tagService.findAll();
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(tagDOS);
    }

    @Override
    public Result<List<TagDO>> getByName(String name) {
        List<TagDO> tagDOS;
        try {
            tagDOS = tagService.getByName(name);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(tagDOS);
    }

    @Override
    public Result<Void> delete(Long id) {
        try {
            tagService.delete(id);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }
}
