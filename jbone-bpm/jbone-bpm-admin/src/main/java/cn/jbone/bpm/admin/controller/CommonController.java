package cn.jbone.bpm.admin.controller;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
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
        UserInfoResponseDTO currentUser = (UserInfoResponseDTO) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        UserInfoResponseDTO userModel = userApi.getUserDetailByNameAndServerName(currentUser.getUsername(), jboneConfiguration.getSys().getServerName()).getData();
        modelMap.put("user", userModel);
    }
}
