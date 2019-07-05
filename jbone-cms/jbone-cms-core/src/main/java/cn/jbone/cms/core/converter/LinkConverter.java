package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.cms.core.dao.entity.Link;
import cn.jbone.cms.core.dao.repository.LinkRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class LinkConverter {

    @Autowired
    private LinkRepository linkRepository;

    public LinkDO toLinkDO(Link link){
        if(link == null){
            return null;
        }

        LinkDO linkDO = new LinkDO();
        BeanUtils.copyProperties(link,linkDO);
        return linkDO;
    }

    public List<LinkDO> toLinkDOs(List<Link> links){
        if(CollectionUtils.isEmpty(links)){
            return null;
        }

        List<LinkDO> linkDOS = new ArrayList<>();
        for (Link link : links){
            LinkDO linkDO = toLinkDO(link);
            if(linkDO != null){
                linkDOS.add(linkDO);
            }
        }
        return linkDOS;
    }

    public Link toLink(LinkDO linkDO){
        if(linkDO == null){
            return null;
        }

        Link link = null;
        if(linkDO.getId() != null && linkDO.getId() > 0){
            link = linkRepository.getOne(linkDO.getId());
        }
        if(link == null){
            link = new Link();
        }

        link.setDescription(linkDO.getDescription());
        link.setFrontCover(linkDO.getFrontCover());
        link.setOrders(linkDO.getOrders());
        link.setTitle(linkDO.getTitle());
        link.setUrl(linkDO.getUrl());
        link.setSiteId(linkDO.getSiteId());
        return link;
    }
}
