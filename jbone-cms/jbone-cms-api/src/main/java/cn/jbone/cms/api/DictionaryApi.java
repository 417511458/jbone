package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.DictionaryItemDO;
import cn.jbone.cms.common.dataobject.DictionaryGroupDO;
import cn.jbone.cms.common.dataobject.search.DictionaryGroupSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/dictionary")
public interface DictionaryApi {

    @RequestMapping(value = "/addOrUpdateGroup",method = {RequestMethod.POST})
    Result<Void> addOrUpdateGroup(@RequestBody DictionaryGroupDO dictionaryGroupDO);

    @RequestMapping(value = "/deleteGroup",method = {RequestMethod.DELETE})
    Result<Void> deleteGroup(@RequestParam("id") Integer id);

    @RequestMapping(value = "/getGroup",method = {RequestMethod.GET})
    Result<DictionaryGroupDO> getGroup(@RequestParam("id") Integer id);

    @RequestMapping(value = "/requestGroup",method = {RequestMethod.POST})
    Result<PagedResponseDO<DictionaryGroupDO>> requestGroup(@RequestBody DictionaryGroupSearchDO dictionaryGroupSearchDO);


    @RequestMapping(value = "/addOrUpdateItem",method = {RequestMethod.POST})
    Result<Void> addOrUpdateItem(@RequestBody DictionaryItemDO dictionaryItemDO);

    @RequestMapping(value = "/deleteItem",method = {RequestMethod.DELETE})
    Result<Void> deleteItem(@RequestParam("id") Integer id);

    @RequestMapping(value = "/getItem",method = {RequestMethod.GET})
    Result<DictionaryItemDO> getItem(@RequestParam("id") Integer id);

    @RequestMapping(value = "/getItems",method = {RequestMethod.GET})
    Result<List<DictionaryItemDO>> getItems(@RequestParam("groupId") Integer groupId);

    @RequestMapping(value = "/getItemsByCode",method = {RequestMethod.GET})
    Result<List<DictionaryItemDO>> getItemsByCode(@RequestParam("code") String code);

}
