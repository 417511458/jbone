package cn.jbone.cms.portal.controller;

import cn.jbone.cms.portal.collectors.DataCollectorHandler;
import cn.jbone.cms.portal.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtmlController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private DataCollectorHandler dataHandler;

    @RequestMapping("{pageName}.html")
    public String index(ModelMap modelMap, @PathVariable(value="pageName") String pageName){

        return commonService.getTemplatePage(pageName);
    }
}
