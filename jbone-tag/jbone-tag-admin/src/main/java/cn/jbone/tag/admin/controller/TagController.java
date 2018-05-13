package cn.jbone.tag.admin.controller;

import cn.jbone.common.ui.result.Result;
import cn.jbone.common.utils.ResultUtils;
import cn.jbone.tag.api.model.CreateTagModel;
import cn.jbone.tag.api.model.TagModel;
import cn.jbone.tag.api.model.UpdateTagModel;
import cn.jbone.tag.dao.domain.TagInfoEntity;
import cn.jbone.tag.service.TagService;
import cn.jbone.tag.service.model.ListModel;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;


/**
 * 标签管理
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/21 22:59
 */
@Controller
@RequestMapping("tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @RequiresPermissions("tag:tagInfo:read")
    @RequestMapping("index")
    public String index(ModelMap modelMap) {
        return "pages/tag/index";
    }

    @RequiresPermissions("tag:tagInfo:create")
    @Description("跳转至新增标签页面")
    @RequestMapping("/toCreate")
    public String toCreate(ModelMap modelMap) {
        return "pages/tag/create";
    }

    @RequiresPermissions("tag:tagInfo:update")
    @Description("跳转至更新标签页面")
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id, ModelMap model) {
        UpdateTagModel tagModel = tagService.findTagById(id);
        model.put("tagModel", tagModel);
        return "pages/tag/update";
    }

    @Description("标签管理分页查询")
    @RequiresPermissions("tag:tagInfo:read")
    @RequestMapping("/list")
    @ResponseBody
    public Result list(ListModel listModel) {
        PageRequest pageRequest = new PageRequest(listModel.getPageNumber() - 1, listModel.getPageSize(), Sort.Direction.fromString(listModel.getSortOrder()), listModel.getSortName());
        //分页查询
        Page<TagInfoEntity> page = tagService.findPage(listModel.getSearchText(), pageRequest);
        List<TagModel> infoEntityList = tagService.getBaseInfos(page.getContent());
        return ResultUtils.wrapSuccess(page.getTotalElements(), infoEntityList);
    }

    @RequiresPermissions("tag:tagInfo:create")
    @Description("执行新增标签")
    @RequestMapping("/create")
    @ResponseBody
    public Result create(@Validated CreateTagModel createTagModel, BindingResult bindingResult) throws ParseException {
        tagService.save(createTagModel);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("tag:tagInfo:update")
    @Description("执行更新标签")
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@Validated UpdateTagModel updateTagModel, BindingResult bindingResult) throws ParseException {
        tagService.update(updateTagModel);
        return ResultUtils.wrapSuccess();
    }


    @RequiresPermissions("tag:tagInfo:delete")
    @Description("批量删除权限")
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Result delete(@PathVariable("ids") String ids) {
        tagService.delete(ids);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("tag:tagInfo:read")
    @Description("获取标签详细信息")
    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result get(@PathVariable("id") Integer id) {
        return ResultUtils.wrapSuccess(tagService.findTagById(id));
    }

    @RequiresPermissions("tag:tagInfo:read")
    @Description("获取权限")
    @RequestMapping("/getTags/{id}")
    @ResponseBody
    public Result getTags(@PathVariable("id") String id) {
        return ResultUtils.wrapSuccess(tagService.findById(id));
    }

}
