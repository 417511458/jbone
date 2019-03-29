package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.search.ArticleSearchDO;
import cn.jbone.cms.common.dataobject.ArticleRequestDO;
import cn.jbone.cms.common.dataobject.ArticleResponseDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/article")
public interface ArticleApi {

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<ArticleResponseDO> addOrUpdate(@RequestBody ArticleRequestDO articleRequestDO);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id, @RequestParam("token") String token,@RequestParam("userId") Integer userId);

    @RequestMapping(value = "/flushDelete",method = {RequestMethod.DELETE})
    Result<Void> flushDelete(@RequestParam("id") Long id);

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<ArticleResponseDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/hits",method = {RequestMethod.GET})
    Result<Void> hits(@RequestParam("id") Long id);

    @RequestMapping(value = "/commonRequest",method = {RequestMethod.POST})
    Result<PagedResponseDO<ArticleResponseDO>> commonRequest(@RequestBody ArticleSearchDO articleSearchDO);

}
