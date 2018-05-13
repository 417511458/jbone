package cn.jbone.tag.server.api.impl;

import cn.jbone.common.rpc.Result;
import cn.jbone.tag.api.TagApi;
import cn.jbone.tag.api.model.CreateTagModel;
import cn.jbone.tag.api.model.TagModel;
import cn.jbone.tag.api.model.UpdateTagModel;
import cn.jbone.tag.dao.domain.TagInfoEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import cn.jbone.tag.service.TagService;

import java.util.ArrayList;
import java.util.List;

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
     * @see cn.jbone.tag.api.TagApi#batchGetTags(String)
     */
    public Result<List<TagModel>> batchGetTags(String tagIds) {
        List<TagInfoEntity> tagModelList;
        if (StringUtils.isEmpty(tagIds)){
            return Result.wrap404Error("The parameter is wrong");
        }
        String[] split = tagIds.split(",");
        List<Integer> tagIdList = new ArrayList<>();
        for (String ss :
                split) {
            tagIdList.add(Integer.valueOf(ss));
        }
        try {
            tagModelList = tagService.batchGetTags(tagIdList);
            if (tagModelList.size() == 0) {
                return Result.wrap404Error("tag is not found");
            }
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        List<TagModel> tagModels = new ArrayList<>();

        for (TagInfoEntity tagInfo :
                tagModelList) {
            TagModel tagModel = new TagModel();
            BeanUtils.copyProperties(tagInfo, tagModel);
            tagModels.add(tagModel);
        }
        return new Result<>(tagModels);
    }


    /**
     * @see cn.jbone.tag.api.TagApi#GetTagsByPage(String, Integer, Integer)
     */
    public Result<List<TagModel>> GetTagsByPage(String targets, Integer currentPage, Integer pageSize) {
        List<TagInfoEntity> tagModelList = null;
        // todo targetList List
        if (StringUtils.isEmpty(targets)){
            return Result.wrap404Error("The parameter is wrong");
        }
        if (currentPage<1){
            return Result.wrap404Error("Pagesize greater than 1");
        }
        String[] split = targets.split(",");
        List<Integer> targetList = new ArrayList<>();
        for (String ss :
                split) {
            targetList.add(Integer.valueOf(ss));
        }
        try {
            tagModelList = tagService.GetTagsByPage(targetList, currentPage-1, pageSize);

            if (tagModelList.size() == 0) {
                return Result.wrap404Error("tag is not found");
            }
        } catch (Exception e) {
            return Result.wrap500Error(e.getMessage());
        }
        List<TagModel> tagModels = new ArrayList<>();
        for (TagInfoEntity tagInfo :
                tagModelList) {
            TagModel tagModel = new TagModel();
            BeanUtils.copyProperties(tagInfo, tagModel);
            tagModels.add(tagModel);
        }
        return new Result<List<TagModel>>(tagModels);
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
