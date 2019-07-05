package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.cms.core.dao.entity.Tag;
import cn.jbone.cms.core.dao.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class TagConverter {

    @Autowired
    private TagRepository tagRepository;

    public TagDO toTagDO(Tag tag){
        if(tag == null){
            return null;
        }

        TagDO tagDO = new TagDO();
        tagDO.setId(tag.getId());
        tagDO.setName(tag.getName());
        tagDO.setSiteId(tag.getSiteId());
        return tagDO;
    }

    public List<TagDO> toTagDOs(List<Tag> tags){
        if(CollectionUtils.isEmpty(tags)){
            return null;
        }

        List<TagDO> tagDOS = new ArrayList<>();
        for (Tag tag : tags){
            TagDO tagDO = toTagDO(tag);
            if(tagDO != null){
                tagDOS.add(tagDO);
            }
        }
        return tagDOS;
    }


    public Tag toTag(TagDO tagDO){
        if(tagDO == null){
            return null;
        }

        Tag tag = null;

        if(tagDO.getId() != null && tagDO.getId() > 0){
            tag = tagRepository.getOne(tagDO.getId());
        }

        if(tag == null){
            tag = new Tag();
        }
        tag.setId(tagDO.getId());
        tag.setName(tagDO.getName());
        tag.setSiteId(tagDO.getSiteId());
        return tag;
    }

    public List<Tag> toTags(List<TagDO> tagDOS){
        if(CollectionUtils.isEmpty(tagDOS)){
            return null;
        }

        List<Tag> tags = new ArrayList<>();
        for (TagDO tagDO : tagDOS){
            Tag tag = toTag(tagDO);
            if(tag != null){
                tags.add(tag);
            }
        }
        return tags;
    }

    public List<Tag> toTagsByIds(List<Long> tagIds){
        if(CollectionUtils.isEmpty(tagIds)){
            return null;
        }

        List<Tag> tags = new ArrayList<>();
        for (Long tagId : tagIds){
            Tag tag = tagRepository.getOne(tagId);
            if(tag != null){
                tags.add(tag);
            }
        }
        return tags;
    }
}
