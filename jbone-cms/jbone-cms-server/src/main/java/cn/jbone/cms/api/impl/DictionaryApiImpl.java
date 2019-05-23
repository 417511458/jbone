package cn.jbone.cms.api.impl;

import cn.jbone.cms.api.DictionaryApi;
import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.DictionaryGroupDO;
import cn.jbone.cms.common.dataobject.search.DictionaryGroupSearchDO;
import cn.jbone.cms.core.service.DictionaryService;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictionaryApiImpl implements DictionaryApi {

    @Autowired
    private DictionaryService dictionaryService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Result<Void> addOrUpdateGroup(@RequestBody DictionaryGroupDO dictionaryGroupDO) {
        try {
            dictionaryService.addOrUpdateGroup(dictionaryGroupDO);
        }catch (Exception e) {
            logger.warn("DictionaryApiImpl addOrUpdateGroup error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> deleteGroup(Integer id) {
        try {
            dictionaryService.deleteGroup(id);
        }catch (Exception e) {
            logger.warn("DictionaryApiImpl deleteGroup error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<DictionaryGroupDO> getGroup(Integer id) {
        DictionaryGroupDO dictionaryGroupDO = null;
        try {
            dictionaryGroupDO = dictionaryService.getGroup(id);
        } catch (Exception e) {
            logger.warn("DictionaryApiImpl getGroup error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(dictionaryGroupDO);
    }

    @Override
    public Result<PagedResponseDO<DictionaryGroupDO>> requestGroup(@RequestBody DictionaryGroupSearchDO dictionaryGroupSearchDO) {
        PagedResponseDO<DictionaryGroupDO> pagedResponseDO = null;
        try {
            pagedResponseDO = dictionaryService.requestGroup(dictionaryGroupSearchDO);
        } catch (Exception e) {
            logger.warn("DictionaryApiImpl requestGroup error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(pagedResponseDO);
    }

    @Override
    public Result<Void> addOrUpdateItem(@RequestBody DictionaryItemDO dictionaryItemDO) {
        try {
            dictionaryService.addOrUpdateItem(dictionaryItemDO);
        } catch (Exception e) {
            logger.warn("DictionaryApiImpl addOrUpdateItem error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<Void> deleteItem(Integer id) {
        try {
            dictionaryService.deleteItem(id);
        } catch (Exception e) {
            logger.warn("DictionaryApiImpl deleteItem error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    public Result<DictionaryItemDO> getItem(Integer id) {
        DictionaryItemDO itemDO = null;
        try {
            itemDO = dictionaryService.getItem(id);
        } catch (Exception e) {
            logger.warn("DictionaryApiImpl getItem error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(itemDO);
    }

    @Override
    public Result<List<DictionaryItemDO>> getItems(Integer groupId) {
        List<DictionaryItemDO> itemDOS = null;
        try {
            itemDOS = dictionaryService.getItems(groupId);
        } catch (Exception e) {
            logger.warn("DictionaryApiImpl getItems error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(itemDOS);
    }
}
