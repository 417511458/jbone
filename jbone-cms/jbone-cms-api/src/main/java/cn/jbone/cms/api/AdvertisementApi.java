package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.AdvertisementDO;
import cn.jbone.cms.common.dataobject.search.AdvertisementSearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/advertisement")
public interface AdvertisementApi {
    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody AdvertisementDO advertisementDO,@RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id, @RequestHeader("userId") Integer userId);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<AdvertisementDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/commonRequest",method = {RequestMethod.POST})
    Result<PagedResponseDO<AdvertisementDO>> commonRequest(@RequestBody AdvertisementSearchDO advertisementSearchDO);

    @RequestMapping(value = "/findAllMap",method = {RequestMethod.GET})
    Result<Map<String, List<AdvertisementDO>>> findAllMap();

}
