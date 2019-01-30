package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.LinkDO;
import cn.jbone.cms.core.converter.LinkConverter;
import cn.jbone.cms.core.dao.entity.Link;
import cn.jbone.cms.core.dao.repository.LinkRepository;
import cn.jbone.common.exception.ObjectNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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

    public void batchDelete(String ids){
        String[] idArray = ids.split(",");
        if(idArray == null || idArray.length <= 0){
            return;
        }
        List<Link> links = new ArrayList<>();
        for (String id: idArray){
            if(StringUtils.isBlank(id)){
                continue;
            }
            Link link = new Link();
            link.setId(Long.parseLong(id));
            links.add(link);
        }
        if(!CollectionUtils.isEmpty(links)){
            linkRepository.deleteInBatch(links);
        }

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
