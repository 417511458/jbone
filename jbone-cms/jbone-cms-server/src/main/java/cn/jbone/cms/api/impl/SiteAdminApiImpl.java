package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.SiteAdminApi;
import cn.jbone.cms.common.dataobject.BatchSaveSiteAdminDO;
import cn.jbone.cms.core.service.SiteAdminService;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import cn.jbone.sys.common.UserResponseDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SiteAdminApiImpl implements SiteAdminApi {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SiteAdminService siteAdminService;

    @Override
    public Result<List<UserResponseDO>> getBySiteId(Integer siteId) {
        List<UserResponseDO> list = null;
        try {
            list = siteAdminService.getBySiteId(siteId);
        } catch (JboneException e) {
            logger.warn("getBySiteId error",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("getBySiteId error",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(list);
    }

    @Override
    public Result<Void> addOrUpdate(@RequestBody BatchSaveSiteAdminDO batchSaveSiteAdminDO) {
        try {
            siteAdminService.addOrUpdate(batchSaveSiteAdminDO);
        } catch (JboneException e) {
            logger.warn("addOrUpdate error",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.error("addOrUpdate error",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }
}
