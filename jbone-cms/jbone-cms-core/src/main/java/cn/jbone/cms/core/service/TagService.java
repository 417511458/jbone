package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.cms.core.converter.TagConverter;
import cn.jbone.cms.core.dao.entity.Tag;
import cn.jbone.cms.core.dao.repository.ArticleRepository;
import cn.jbone.cms.core.dao.repository.TagRepository;
import cn.jbone.common.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagConverter tagConverter;

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * tag管理只有一个，就是查询所有的标签，并统计标签对应的文章数量
     * @return
     */
    public List<TagDO> findAll(){
        List<Tag> tags = tagRepository.findAll();
        return fillArticleCount(tags);
    }

    private List<TagDO> fillArticleCount(List<Tag> tags){
        if(CollectionUtils.isEmpty(tags)){
            return null;
        }
        List<TagDO> tagDOS = new ArrayList<>();
        if(!CollectionUtils.isEmpty(tags)){
            for (Tag tag : tags){
                TagDO tagDO = tagConverter.toTagDO(tag);
                tagDO.setArticleCount(articleRepository.countByTags(Arrays.asList(tag)));
                tagDOS.add(tagDO);
            }
        }
        Collections.sort(tagDOS);
        return tagDOS;
    }

    public List<TagDO> getByName(String name){
        List<Tag> tags = tagRepository.findByNameLike(name);
        return fillArticleCount(tags);
    }

    public void delete(Long id){
        if(!tagRepository.existsById(id)){
            throw new ObjectNotFoundException("标签不存在");
        }
        tagRepository.deleteById(id);
    }
}
