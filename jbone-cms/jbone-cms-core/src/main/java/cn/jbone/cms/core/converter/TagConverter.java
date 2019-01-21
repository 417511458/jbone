package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.module.article.TagDO;
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
}
