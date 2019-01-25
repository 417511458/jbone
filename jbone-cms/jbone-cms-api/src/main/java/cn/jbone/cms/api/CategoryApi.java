package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.common.rpc.Result;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/category")
public interface CategoryApi {

    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST},consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<Void> addOrUpdate(@RequestBody CategoryDO categoryDO);

    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id);

    @RequestMapping(value = "/getCategoryTree",method = {RequestMethod.GET})
    Result<List<CategoryDO>> getCategoryTree();

}
