package com.majunwei.jbone.sys.admin.controller;

import com.majunwei.jbone.common.ui.result.Result;
import com.majunwei.jbone.common.utils.ResultUtils;
import com.majunwei.jbone.sys.dao.domain.RbacSystemEntity;
import com.majunwei.jbone.sys.service.SystemService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
@RequestMapping("system")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequiresRoles("admin")
    @RequestMapping("/index")
    public String index(){
        return "pages/system/index";
    }

    @RequiresRoles("admin")
    @RequestMapping("/list")
    @ResponseBody
    public Result list(HttpServletRequest request){
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));

        String searchText = request.getParameter("searchText");
        String sortName = request.getParameter("sortName");
        String sortOrder = request.getParameter("sortOrder");

        PageRequest pageRequest = new PageRequest(pageNumber-1,pageSize, Sort.Direction.fromString(sortOrder),sortName);
        //分页查找
        Page<RbacSystemEntity> page = systemService.findPage(searchText,pageRequest);

        return ResultUtils.wrapSuccess(page.getTotalElements(),page.getContent());
    }


    @RequestMapping("/create")
    @ResponseBody
    public Result create(RbacSystemEntity systemEntity){
        systemService.save(systemEntity);
        return ResultUtils.wrapSuccess();
    }

    @RequestMapping("/delete/{ids}")
    @ResponseBody
    public Result delete(@PathVariable("ids")String ids){
        systemService.delete(ids);
        return ResultUtils.wrapSuccess();
    }
}
