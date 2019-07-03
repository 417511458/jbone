package cn.jbone.cms.core.service;

import cn.jbone.cms.common.dataobject.BatchSaveSiteAdminDO;
import cn.jbone.cms.core.dao.entity.SiteAdmin;
import cn.jbone.cms.core.dao.repository.SiteAdminRepository;
import cn.jbone.cms.core.dao.repository.SiteRepository;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.common.UserRequestDO;
import cn.jbone.sys.common.UserResponseDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiteAdminService {
    @Autowired
    private SiteAdminRepository siteAdminRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private UserApi userApi;

    public List<UserResponseDO> getBySiteId(Integer siteId) {
        if(siteId == null || siteId <= 0){
            throw new JboneException("参数错误");
        }
        if(!siteRepository.existsById(siteId)){
            throw new JboneException("站点不存在");
        }

        List<SiteAdmin> siteAdmins = siteAdminRepository.findBySiteId(siteId);
        if(!CollectionUtils.isEmpty(siteAdmins)){
            List<Integer> userIds = new ArrayList<>();
            for (SiteAdmin siteAdmin : siteAdmins){
                userIds.add(siteAdmin.getUserId());
            }

            UserRequestDO userRequestDO = UserRequestDO.buildSimple(userIds);
            userRequestDO.setPageSize(100);

            Result<PagedResponseDO<UserResponseDO>> result = userApi.commonSearch(userRequestDO);
            if(result != null && result.isSuccess()){
                return result.getData().getDatas();
            }
        }

        return null;
    }

    public void addOrUpdate(BatchSaveSiteAdminDO batchSaveSiteAdminDO) {
        if(batchSaveSiteAdminDO.getSiteId() == null || batchSaveSiteAdminDO.getSiteId() <= 0){
            throw new JboneException("参数错误");
        }
        if(!siteRepository.existsById(batchSaveSiteAdminDO.getSiteId())){
            throw new JboneException("站点不存在");
        }
        List<SiteAdmin> siteAdmins = siteAdminRepository.findBySiteId(batchSaveSiteAdminDO.getSiteId());
        if(!CollectionUtils.isEmpty(siteAdmins)){
            siteAdminRepository.deleteInBatch(siteAdmins);
        }
        if(!CollectionUtils.isEmpty(batchSaveSiteAdminDO.getUserIds())){
            List<SiteAdmin> newSiteAdmins = new ArrayList<>();
            for (Integer userId:batchSaveSiteAdminDO.getUserIds()) {
                SiteAdmin siteAdmin = new SiteAdmin();
                siteAdmin.setUserId(userId);
                siteAdmin.setSiteId(batchSaveSiteAdminDO.getSiteId());
                newSiteAdmins.add(siteAdmin);
            }
            siteAdminRepository.saveAll(newSiteAdmins);
        }
    }
}
