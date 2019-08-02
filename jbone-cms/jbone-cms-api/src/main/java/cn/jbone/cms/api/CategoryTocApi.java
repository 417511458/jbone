package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.*;
import cn.jbone.common.rpc.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/categoryToc")
public interface CategoryTocApi {

    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<CategoryTocDO> get(@RequestParam("id") Long id);

    @RequestMapping(value = "/getByCategoryAndArticle",method = {RequestMethod.GET})
    Result<CategoryTocDO> getByCategoryAndArticle(@RequestParam("categoryId") Long categoryId,@RequestParam("articleId") Long articleId);

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<CategoryTocDO> addOrUpdate(@RequestBody CategoryTocDO categoryTocDO);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id);

    @RequestMapping(value = "/getTree",method = {RequestMethod.GET})
    Result<List<CategoryTocDO>> getTree(@RequestParam("categoryId") Long categoryId);


}
