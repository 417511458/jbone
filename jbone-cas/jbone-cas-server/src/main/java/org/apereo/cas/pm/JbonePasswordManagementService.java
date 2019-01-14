package org.apereo.cas.pm;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.api.dto.request.ChangePasswordRequestDTO;
import cn.jbone.sys.api.dto.response.UserBaseInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserSecurityQuestionsResponseDTO;
import org.apereo.cas.CipherExecutor;
import org.apereo.cas.authentication.Credential;
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
        super(properties,cipherExecutor, issuer);
        this.userApi = userApi;
    }

    /**
     * 获取用户的邮件
     * @param username
     * @return
     */
    @Override
    public String findEmail(String username) {
        Result<UserBaseInfoResponseDTO> userModelResult = userApi.getUserByName(username);
        if(userModelResult.isSuccess() && userModelResult.getData() != null){
            return userModelResult.getData().getEmail();
        }
        return null;
    }

    /**
     * 获取密保问题
     * @param username
     * @return
     */
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

    /**
     * 执行更新
     * @param c
     * @param bean
     * @return
     * @throws InvalidPasswordException
     */
    @Override
    public boolean changeInternal(Credential c, PasswordChangeBean bean) throws InvalidPasswordException {
        ChangePasswordRequestDTO requestDTO = new ChangePasswordRequestDTO();
        requestDTO.setUsername(c.getId());
        requestDTO.setPassword(bean.getPassword());
        requestDTO.setConfirmedPassword(bean.getConfirmedPassword());
        Result<Void> result = userApi.changePassword(requestDTO);
        return result.isSuccess();
    }
}
