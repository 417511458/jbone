package cn.jbone.tag.service;

import cn.jbone.common.exception.JboneException;
import cn.jbone.tag.api.model.CreateTagModel;
import cn.jbone.tag.api.model.TagModel;
import cn.jbone.tag.api.model.UpdateTagModel;
import cn.jbone.tag.dao.domain.TagInfoEntity;
import cn.jbone.tag.dao.repository.TagInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 1:29
 */
@Transactional
@Service
public class TagService {

    @Autowired
    private TagInfoRepository tagInfoRepository;

    /**
     * 根据标签号批量获取标签
     * @param tagIdList 标签主键列表
     * @return 标签列表
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:34
     */
    public List<TagModel> batchGetTags(Set<String> tagIdList) {
        List<TagModel> modelList = new LinkedList<TagModel>();
        for (String tagId : tagIdList) {
            //todo  根据标签查询
//            TagInfoEntity tagInfoEntity = tagInfoRepository.findOne();
        }
        return null;
    }

    /**
     * 根据标签类别批量获取标签
     * @param targetList  标签类别
     * @param currentPage 当前页数
     * @param pageSize    页大小
     * @return
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:33
     */
    public List<TagModel> GetTagsByPage(List<Integer> targetList, Integer currentPage, Integer pageSize) {
        //todo  复杂组合查询
        return null;
    }

    /**
     * 保存标签
     * @param createTagModel 创建页签
     * @return
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:33
     */
    public void save(CreateTagModel createTagModel) {
        TagInfoEntity tagInfoEntity = new TagInfoEntity();
        BeanUtils.copyProperties(createTagModel, tagInfoEntity);
        tagInfoRepository.save(tagInfoEntity);
    }

    /**
     * 更新标签
     * @param updateTagModel 更新页签
     * @return
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:33
     */
    public void update(UpdateTagModel updateTagModel) {
        TagInfoEntity tagInfoEntity = tagInfoRepository.findOne(updateTagModel.getId());

        if (tagInfoEntity == null) {
            throw new JboneException("没有找到标签");
        }
        BeanUtils.copyProperties(updateTagModel, tagInfoEntity);
        tagInfoRepository.save(tagInfoEntity);
    }

    /**
     * 批量删除标签
     * @param ids 主键
     * @return
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:33
     */
    public void delete(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            if (StringUtils.isBlank(id)) {
                continue;
            }
            tagInfoRepository.delete(Integer.parseInt(id));
        }
    }

    /**
     * 根据主键查询标签
     * @param id 主键id
     * @return 标签
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:32
     */
    public TagModel findTagById(Integer id) {
        TagModel tagModel = null;
        TagInfoEntity tagInfoEntity = tagInfoRepository.findOne(id);
        if (tagInfoEntity == null) {
            throw new JboneException("没有找到标签");
        }
        BeanUtils.copyProperties(tagInfoEntity, tagModel);
        return tagModel;
    }
}
