package cn.jbone.cms.core.converter;

import cn.jbone.cms.common.dataobject.SiteAdminDO;
import cn.jbone.cms.core.dao.entity.SiteAdmin;
import cn.jbone.cms.core.dao.repository.SiteAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class SiteAdminConverter {

    @Autowired
    private SiteAdminRepository siteAdminRepository;

    public SiteAdminDO toDO(SiteAdmin siteAdmin){
        if(siteAdmin == null){
            return null;
        }
        SiteAdminDO siteAdminDO = new SiteAdminDO();
        siteAdminDO.setId(siteAdmin.getId());
        siteAdminDO.setSiteId(siteAdmin.getSiteId());
        siteAdminDO.setUserId(siteAdmin.getUserId());

        return siteAdminDO;
    }

    public List<SiteAdminDO> toDOS(List<SiteAdmin> siteAdmins){
        if(CollectionUtils.isEmpty(siteAdmins)){
            return null;
        }
        List<SiteAdminDO> list = new ArrayList<>();
        for (SiteAdmin siteAdmin : siteAdmins){
            SiteAdminDO siteAdminDO = toDO(siteAdmin);
            if(siteAdminDO != null){
                list.add(siteAdminDO);
            }
        }
        return list;
    }

    public SiteAdmin toEntity(SiteAdminDO siteAdminDO){
        if(siteAdminDO == null){
            return null;
        }

        SiteAdmin siteAdmin = null;
        if(siteAdminDO.getId() != null && siteAdminDO.getId() > 0){
            siteAdmin = siteAdminRepository.getOne(siteAdminDO.getId());
        }
        if(siteAdmin == null){
            siteAdmin = new SiteAdmin();
        }
        siteAdmin.setSiteId(siteAdminDO.getSiteId());
        siteAdmin.setUserId(siteAdminDO.getUserId());

        return siteAdmin;
    }
}
