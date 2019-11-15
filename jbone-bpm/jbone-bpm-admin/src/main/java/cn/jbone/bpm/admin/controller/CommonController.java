package cn.jbone.bpm.admin.controller;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.system.api.UserApi;
import cn.jbone.system.common.UserResponseDO;
import org.apache.shiro.SecurityUtils;
import org.springframework.ui.ModelMap;

public class CommonController {

    /**
     * 获取当前系统的用户对应的系统权限
     * @param modelMap           存储上下文信息的Map集合
     * @param userApi            远程权限系统接口
     * @param jboneConfiguration 配置对象
     * @return 无
     * @author HoldDie
     * @email holddie@163.com
     * @date 2018/3/25 17:45
     */
    public void setCurrentUser(ModelMap modelMap, UserApi userApi, JboneConfiguration jboneConfiguration) {
        UserResponseDO currentUser = (UserResponseDO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        modelMap.put("user", currentUser);
    }
}
