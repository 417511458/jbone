package cn.jbone.sm.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class IndexController {
    @RequestMapping(value = "/", method = GET)
    public ModelAndView redirectRoot() {
        return new ModelAndView("redirect:/admin/");
    }
}
