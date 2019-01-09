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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 1:29
 */
@Transactional
@Service
public class TagService {

    private final TagInfoRepository tagInfoRepository;

    @Autowired
    public TagService(TagInfoRepository tagInfoRepository) {
        this.tagInfoRepository = tagInfoRepository;
    }

    /**
     * 根据标签号批量获取标签
     * @param tagIdList 标签主键列表
     * @return 标签列表
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:34
     */
    public List<TagInfoEntity> batchGetTags(List<Integer> tagIdList) {
        return tagInfoRepository.findById(tagIdList);
    }

    /**
     * 根据标签类别批量获取标签
     * @param targetList  标签类别
     * @param currentPage 当前页数
     * @param pageSize    页大小
     * @return List<TagModel>
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:33
     */
    public List<TagInfoEntity> GetTagsByPage(List<Integer> targetList, Integer currentPage, Integer pageSize) {
        Pageable pageable = new PageRequest(currentPage,pageSize);
        return tagInfoRepository.findByTarget(targetList,pageable);
    }

    /**
     * 保存标签
     * @param createTagModel 创建页签
     * @return void
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:33
     */
    public void save(CreateTagModel createTagModel) throws ParseException {
        TagInfoEntity tagInfoEntity = new TagInfoEntity();
        BeanUtils.copyProperties(createTagModel, tagInfoEntity);
        // 时间格式转化
        String start_time = createTagModel.getTime_line().substring(0, 10);
        String end_time = createTagModel.getTime_line().substring(13, 23);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        tagInfoEntity.setStart_time(new Date(dateFormat.parse(start_time).getTime()));
        tagInfoEntity.setEnd_time(new Date(dateFormat.parse(end_time).getTime()));
        tagInfoRepository.save(tagInfoEntity);
    }

    /**
     * 更新标签
     * @param updateTagModel 更新页签
     * @return void
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 2:33
     */
    public void update(UpdateTagModel updateTagModel) throws ParseException {
        TagInfoEntity tagInfoEntity = tagInfoRepository.getOne(updateTagModel.getId());

        if (tagInfoEntity == null) {
            throw new JboneException("没有找到标签");
        }
        BeanUtils.copyProperties(updateTagModel, tagInfoEntity);
        // 时间格式转化
        String start_time = updateTagModel.getTime_line().substring(0, 10);
        String end_time = updateTagModel.getTime_line().substring(13, 23);
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        tagInfoEntity.setStart_time(new Date(dateFormat.parse(start_time).getTime()));
        tagInfoEntity.setEnd_time(new Date(dateFormat.parse(end_time).getTime()));

        tagInfoRepository.save(tagInfoEntity);
    }

    /**
     * 批量删除标签
     * @param ids 主键
     * @return void
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
            tagInfoRepository.deleteById(Integer.parseInt(id));
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
    public UpdateTagModel findTagById(Integer id) {
        UpdateTagModel tagModel = new UpdateTagModel();
        TagInfoEntity tagInfoEntity = tagInfoRepository.getOne(id);
        if (tagInfoEntity == null) {
            throw new JboneException("没有找到标签");
        }
        BeanUtils.copyProperties(tagInfoEntity, tagModel);
        // 对于时间格式的转化
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        tagModel.setTime_line(dateFormat.format(tagInfoEntity.getStart_time()) + " - " + dateFormat.format(tagInfoEntity.getEnd_time()));
        return tagModel;
    }

    /**
     * 分页查询标签
     * @param condition   条件
     * @param pageRequest 分页封装
     * @return 标签列表
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 21:20
     */
    public Page<TagInfoEntity> findPage(String condition, PageRequest pageRequest) {
        return tagInfoRepository.findAll(new TagSpecification(condition), pageRequest);
    }

    /**
     * 实体转换
     * @param tagInfoEntities 标签实体
     * @return 标签列表
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 21:39
     */
    public List<TagModel> getBaseInfos(List<TagInfoEntity> tagInfoEntities) {
        List<TagModel> tagModelList = new ArrayList<TagModel>();
        if (tagInfoEntities == null || tagInfoEntities.isEmpty()) {
            return tagModelList;
        }
        for (TagInfoEntity taginfo :
                tagInfoEntities) {
            TagModel tagModel = new TagModel();
            BeanUtils.copyProperties(taginfo, tagModel);
            tagModelList.add(tagModel);
        }
        return tagModelList;
    }

    /**
     * 根据标签ID查找标签
     * @param id 标签ID
     * @return 标签
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 21:49
     */
    public TagModel findById(String id) {
        TagInfoEntity tagInfoEntity = null;
        if (StringUtils.isNotEmpty(id)) {
            tagInfoEntity = tagInfoRepository.findById(Integer.parseInt(id));
        }
        return getBaseInfo(tagInfoEntity);
    }

    /**
     * 单体PO和VO转换
     * @param tagInfoEntity 标签PO
     * @return 标签实体
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/22 21:48
     */
    private TagModel getBaseInfo(TagInfoEntity tagInfoEntity) {
        TagModel tagModel = new TagModel();
        BeanUtils.copyProperties(tagInfoEntity, tagModel);
        return tagModel;
    }

    /**
     * 声明查询，用户模糊查找标签名称
     * @author HoldDie
     * @version v1.0.0
     * @email holddie@163.com
     * @date 2018/3/22 21:33
     */
    private class TagSpecification implements Specification<TagInfoEntity> {
        private String condition;

        TagSpecification(String condition) {
            this.condition = condition;
        }

        public Predicate toPredicate(Root<TagInfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("name");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"));
            return predicate;
        }
    }
}
