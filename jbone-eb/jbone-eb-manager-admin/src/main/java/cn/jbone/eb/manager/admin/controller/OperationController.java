package cn.jbone.eb.manager.admin.controller;

import cn.jbone.common.service.vo.SearchListVo;
import cn.jbone.common.ui.result.Result;
import cn.jbone.common.utils.ResultUtils;
import cn.jbone.eb.manager.core.service.OperationService;
import cn.jbone.eb.manager.core.service.vo.operation.CreateOperationVo;
import cn.jbone.eb.manager.core.service.vo.operation.OperationBaseInfoVo;
import cn.jbone.eb.manager.core.service.vo.operation.OperationPositionListVo;
import cn.jbone.eb.manager.core.service.vo.operation.UpdateOperationVo;
import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("operation")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @RequiresPermissions("eb:manager:operation:read")
    @RequestMapping("/index")
    public String index(){
        return "pages/operation/index";
    }

    @RequiresPermissions("eb:manager:operation:read")
    @Description("运营位管理分页查询")
    @RequestMapping("/list")
    @ResponseBody
    public Result list(SearchListVo listBO){
        OperationPositionListVo listVo = operationService.findByPage(listBO);
        return ResultUtils.wrapSuccess(listVo.getTotal(),listVo.getRows());
    }

    @RequiresPermissions("eb:manager:operation:create")
    @Description("跳转至新增运营位页面")
    @RequestMapping("/toCreate")
    public String toCreate(){
        return "pages/operation/create";
    }

    @RequiresPermissions("eb:manager:operation:create")
    @Description("执行新增运营位")
    @RequestMapping("/create")
    @ResponseBody
    public Result create(@Validated CreateOperationVo createOperationVo, BindingResult bindingResult){
        UserInfoResponseDTO currentUser = (UserInfoResponseDTO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        createOperationVo.setOperator(currentUser.getUsername());
        operationService.create(createOperationVo);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("eb:manager:operation:update")
    @Description("跳转至更新运营位页面")
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")Integer id, ModelMap modelMap){
        OperationBaseInfoVo operationBaseInfoVo = operationService.get(id);
        modelMap.put("operationBaseInfoVo",operationBaseInfoVo);
        return "pages/operation/update";
    }

    @RequiresPermissions("eb:manager:operation:update")
    @Description("执行更新运营位")
    @RequestMapping("/update")
    @ResponseBody
    public Result update(@Validated UpdateOperationVo updateOperationVo, BindingResult bindingResult){
        UserInfoResponseDTO currentUser = (UserInfoResponseDTO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        updateOperationVo.setOperator(currentUser.getUsername());
        operationService.update(updateOperationVo);
        return ResultUtils.wrapSuccess();
    }

    @RequiresPermissions("eb:manager:operation:delete")
    @Description("批量删除运营位")
    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Result delete(@PathVariable("ids")String ids){
        operationService.delete(ids);
        return ResultUtils.wrapSuccess();
    }

    @RequestMapping("/get/{id}")
    @Description("获取运营位详情")
    @ResponseBody
    public Result get(@PathVariable("id")int id){
        return ResultUtils.wrapSuccess(operationService.get(id));
    }
}
