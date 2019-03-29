package cn.jbone.cms.api;

import cn.jbone.cms.common.dataobject.CategoryDO;
import cn.jbone.cms.common.dataobject.search.CategorySearchDO;
import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import feign.Headers;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/category")
public interface CategoryApi {

    /**
     * 添加/更新栏目
     * @param categoryDO
     * @return
     */
    @RequestMapping(value = "/addOrUpdate",method = {RequestMethod.POST})
    Result<Void> addOrUpdate(@RequestBody CategoryDO categoryDO);


    /**
     * 删除栏目
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete",method = {RequestMethod.DELETE})
    Result<Void> delete(@RequestParam("id") Long id);


    @RequestMapping(value = "/get",method = {RequestMethod.GET})
    Result<CategoryDO> get(@RequestParam("id") Long id);

    /**
     * 获取栏目树
     * @return
     */
    @RequestMapping(value = "/getCategoryTree",method = {RequestMethod.GET})
    Result<List<CategoryDO>> getCategoryTree();

    /**
     * 获取栏目树
     * @return
     */
    @RequestMapping(value = "/requestCategorysTree",method = {RequestMethod.POST},consumes = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-Type: application/json")
    Result<List<CategoryDO>> requestCategorysTree(@RequestBody CategorySearchDO categorySearchDO);

    /**
     * 获取栏目列表
     * @return
     */
    @RequestMapping(value = "/requestCategorys",method = {RequestMethod.POST})
    Result<PagedResponseDO<CategoryDO>> requestCategorys(@RequestBody CategorySearchDO categorySearchDO);

}
