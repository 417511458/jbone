package com.majunwei.jbone.sys.admin.controller;

import com.majunwei.jbone.sys.dao.domain.RbacSystemEntity;
import com.majunwei.jbone.sys.service.SystemService;
import com.netflix.discovery.converters.Auto;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

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
    public Object list(HttpServletRequest request){
        Enumeration<String> names = request.getParameterNames();

        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));

        String searchText = request.getParameter("searchText");
        String sortName = request.getParameter("sortName");
        String sortOrder = request.getParameter("sortOrder");



        PageRequest pageRequest = new PageRequest(pageNumber-1,pageSize, Sort.Direction.fromString(sortOrder),sortName);
        //分页查找
        Page<RbacSystemEntity> page = systemService.findPage(searchText,pageRequest);

        Map<String,Object> result = new HashMap<String, Object>();
        result.put("total",page.getTotalElements());
        result.put("rows",page.getContent());

        return result;
    }


    @RequestMapping("/create")
    @ResponseBody
    public Object create(Model model){
        return null;
    }
}
