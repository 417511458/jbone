package cn.jbone.tag.server.api.impl;

import cn.jbone.common.rpc.Result;
import cn.jbone.tag.api.TagApi;
import cn.jbone.tag.api.model.CreateTagModel;
import cn.jbone.tag.api.model.TagModel;
import cn.jbone.tag.api.model.UpdateTagModel;
import cn.jbone.tag.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 标签接口实现类
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 1:10
 */
@RestController
public class TagApiImpl implements TagApi {

    private Logger logger = LoggerFactory.getLogger(TagApiImpl.class);

    @Autowired
    private TagService tagService;


    /**
     * @see cn.jbone.tag.api.TagApi#batchGetTags(Set)
     */
    public Result<List<TagModel>> batchGetTags(Set<String> tagIdList) {
        List<TagModel> tagModelList = null;
        try {
            tagModelList = tagService.batchGetTags(tagIdList);

            if (tagModelList == null) {
                return Result.wrap404Error("tag is not found");
            }
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return new Result<List<TagModel>>(tagModelList);
    }


    /**
     * @see cn.jbone.tag.api.TagApi#GetTagsByPage(List, Integer, Integer)
     */
    public Result<List<TagModel>> GetTagsByPage(List<Integer> targetList, Integer currentPage, Integer pageSize) {
        List<TagModel> tagModelList = null;
        try {
            tagModelList = tagService.GetTagsByPage(targetList, currentPage, pageSize);

            if (tagModelList == null) {
                return Result.wrap404Error("tag is not found");
            }
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return new Result<List<TagModel>>(tagModelList);
    }


    /**
     * @see cn.jbone.tag.api.TagApi#save(CreateTagModel)
     */
    public Result save(CreateTagModel createTagModel) {
        try {
            tagService.save(createTagModel);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }


    /**
     * @see cn.jbone.tag.api.TagApi#update(UpdateTagModel)
     */
    public Result update(UpdateTagModel updateTagModel) {
        try {
            tagService.update(updateTagModel);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    public Result delete(String ids) {
        try {
            tagService.delete(ids);
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }


    /**
     * @see cn.jbone.tag.api.TagApi#findTagById(Integer)
     */
    public Result<UpdateTagModel> findTagById(Integer id) {
        UpdateTagModel model = null;
        try {
            model = tagService.findTagById(id);

            if (model == null) {
                return Result.wrap404Error("tag is not found");
            }
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        return new Result<UpdateTagModel>(model);
    }
}
