package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.cms.core.converter.LinkConverter;
import cn.jbone.cms.core.dao.entity.Link;
import cn.jbone.cms.core.dao.repository.LinkRepository;
import cn.jbone.common.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private LinkConverter linkConverter;

    public void addOrUpdate(LinkDO linkDO){
        checkParam(linkDO);
        Link link = linkConverter.toLink(linkDO);
        linkRepository.save(link);
    }

    private void checkParam(LinkDO linkDO){
        Assert.notNull(linkDO.getTitle(),"标题不能为空");
        Assert.notNull(linkDO.getUrl(),"URL不能为空");
    }

    public void delete(Long id){
        if(!linkRepository.existsById(id)){
            throw new ObjectNotFoundException("链接不存在");
        }
        linkRepository.deleteById(id);
    }

    public LinkDO get(Long id){
        Link link = linkRepository.getOne(id);
        LinkDO linkDO = linkConverter.toLinkDO(link);
        return linkDO;
    }

    public List<LinkDO> getAll(){
        List<Link> links = linkRepository.findAll(Sort.by(Sort.Direction.ASC,"orders"));
        return linkConverter.toLinkDOs(links);
    }

}
