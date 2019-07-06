package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.AdvertisementApi;
import cn.jbone.cms.common.dataobject.AdvertisementDO;
import cn.jbone.cms.common.dataobject.search.AdvertisementSearchDO;
import cn.jbone.cms.core.service.AdvertisementService;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.exception.JboneException;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdvertisementApiImpl implements AdvertisementApi {
    @Autowired
    private AdvertisementService advertisementService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Result<Void> addOrUpdate(@RequestBody AdvertisementDO advertisementDO, @RequestHeader("userId") Integer userId) {
        try {
            advertisementDO.setCreator(userId);
            advertisementService.addOrUpdate(advertisementDO);
        } catch (JboneException e) {
            logger.warn("Advertisement addOrUpdate error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Advertisement addOrUpdate error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> delete(Long id, @RequestHeader("userId") Integer userId) {
        try {
            advertisementService.delete(id,userId);
        } catch (JboneException e) {
            logger.warn("Advertisement delete error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Advertisement delete error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<AdvertisementDO> get(Long id) {
        AdvertisementDO advertisementDO = null;
        try {
            advertisementDO = advertisementService.get(id);
        } catch (JboneException e) {
            logger.warn("Advertisement get error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Advertisement get error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(advertisementDO);
    }

    @Override
    public Result<PagedResponseDO<AdvertisementDO>> commonRequest(@RequestBody AdvertisementSearchDO advertisementSearchDO) {
        PagedResponseDO<AdvertisementDO> advertisementDO = null;
        try {
            advertisementDO = advertisementService.commonRequest(advertisementSearchDO);
        } catch (JboneException e) {
            logger.warn("Advertisement commonRequest error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Advertisement commonRequest error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(advertisementDO);
    }

    @Override
    public Result<Map<String, List<AdvertisementDO>>> findAllMap() {
        Map<String, List<AdvertisementDO>> advertisementDO = null;
        try {
            advertisementDO = advertisementService.findAllMap();
        } catch (JboneException e) {
            logger.warn("Advertisement findAllMap error.",e);
            return Result.wrap500Error(e.getMessage());
        } catch (Exception e) {
            logger.warn("Advertisement findAllMap error.",e);
            return Result.wrap500Error("系统错误");
        }
        return Result.wrapSuccess(advertisementDO);
    }
}
