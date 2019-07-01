package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.SiteDO;
import cn.jbone.cms.core.dao.entity.Site;
import cn.jbone.cms.core.dao.repository.SiteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SiteConverter {

    @Autowired
    private SiteRepository siteRepository;

    public SiteDO toSiteDO(Site site){
        if(site == null){
            return null;
        }
        SiteDO siteDO = new SiteDO();
        BeanUtils.copyProperties(site,siteDO);
        return siteDO;
    }

    public List<SiteDO> toSiteDOs(List<Site> sites){
        if(CollectionUtils.isEmpty(sites)){
            return null;
        }
        List<SiteDO> siteDOS = new ArrayList<>();
        for (Site site:sites){
            SiteDO siteDO = toSiteDO(site);
            if(siteDO != null){
                siteDOS.add(siteDO);
            }
        }
        return siteDOS;
    }

    public Site toSite(SiteDO siteDO){
        if(siteDO == null){
            return null;
        }

        Site site = null;
        if(siteDO.getId() != null && siteDO.getId() > 0){
            site = siteRepository.getOne(siteDO.getId());
        }

        if(site == null){
            site = new Site();
        }
        BeanUtils.copyProperties(siteDO,site);
        return site;
    }
}
