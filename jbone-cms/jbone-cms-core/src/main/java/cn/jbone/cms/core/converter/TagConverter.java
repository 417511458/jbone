package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.TagDO;
import cn.jbone.cms.core.dao.entity.Tag;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class TagConverter {
    public TagDO toTagDO(Tag tag){
        if(tag == null){
            return null;
        }

        TagDO tagDO = new TagDO();
        tagDO.setId(tag.getId());
        tagDO.setName(tag.getName());
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

        Tag tag = new Tag();
        tag.setId(tagDO.getId());
        tag.setName(tagDO.getName());
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
}
