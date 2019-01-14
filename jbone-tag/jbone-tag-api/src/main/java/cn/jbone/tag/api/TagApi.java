package cn.jbone.tag.api;

import cn.jbone.common.rpc.Result;
import cn.jbone.tag.api.model.CreateTagModel;
import cn.jbone.tag.api.model.TagModel;
import cn.jbone.tag.api.model.UpdateTagModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 标签接口
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/21 23:05
 */
@RequestMapping("/api/tag")
public interface TagApi {

    /**
     * 批量获取标签（去除已删除和过期标签）
     * @param tagIds 标签ID列表
     * @return 标签列表
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/21 23:38
     */
    @RequestMapping(value = "/batchGetTags")
    Result<List<TagModel>> batchGetTags(@RequestParam("tagIds") String tagIds);


    /**
     * 分页获取标签
     * @param targets     标签分类集合
     * @param currentPage 当前页
     * @param pageSize    页数大小
     * @return 标签列表
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/21 23:42
     */
    @RequestMapping(value = "/getTagsByPage")
    Result<List<TagModel>> GetTagsByPage(@RequestParam("targets") String targets, @RequestParam("currentPage") Integer currentPage, @RequestParam("pageSize") Integer pageSize);


    /**
     * 新增标签
     * @param createTagModel 创建标签实体
     * @return 请求结果
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 0:11
     */
    @RequestMapping(value = "/save")
    Result save(CreateTagModel createTagModel);

    /**
     * 更新标签
     * @param updateTagModel 更新标签实体
     * @return 请求结果
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 0:26
     */
    @RequestMapping(value = "/update")
    Result update(UpdateTagModel updateTagModel);

    /**
     * 批量删除标签
     * @param ids 删除标签主键集合（使用逗号隔开）
     * @return 请求结果
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 0:26
     */
    @RequestMapping(value = "/delete")
    Result delete(String ids);


    /**
     * 根据标签主键查找标签实体
     * @param id 标签主键
     * @return 请求结果
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 0:32
     */
    @RequestMapping(value = "/findTagById")
    Result<UpdateTagModel> findTagById(Integer id);
}
