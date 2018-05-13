package org.apereo.cas.pm;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.api.dto.response.UserBaseInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserSecurityQuestionsResponseDTO;
import org.apereo.cas.CipherExecutor;
import org.apereo.cas.configuration.model.support.pm.PasswordManagementProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Jbone密码管理实现
 */
public class JbonePasswordManagementService extends BasePasswordManagementService {

    private Logger logger = LoggerFactory.getLogger(JbonePasswordManagementService.class);

    private UserApi userApi;

    public JbonePasswordManagementService(CipherExecutor<Serializable, String> cipherExecutor, String issuer, PasswordManagementProperties properties,UserApi userApi) {
        super(cipherExecutor, issuer, properties);
        this.userApi = userApi;
    }

    @Override
    public String findEmail(String username) {
        Result<UserBaseInfoResponseDTO> userModelResult = userApi.getUserByName(username);
        if(userModelResult.isSuccess() && userModelResult.getData() != null){
            return userModelResult.getData().getEmail();
        }
        return null;
    }

    @Override
    public Map<String, String> getSecurityQuestions(String username) {
        Map<String, String> securityQuestions = new LinkedHashMap<>();

        Result<List<UserSecurityQuestionsResponseDTO>> securityQuestionsResult = userApi.getUserSecurityQuestions(username);
        if(securityQuestionsResult.isSuccess() && securityQuestionsResult.getData()!=null){
            for (UserSecurityQuestionsResponseDTO responseDTO : securityQuestionsResult.getData()){
                securityQuestions.put(responseDTO.getQuestion(),responseDTO.getAnswer());
            }
        }
        return securityQuestions;
    }
}
