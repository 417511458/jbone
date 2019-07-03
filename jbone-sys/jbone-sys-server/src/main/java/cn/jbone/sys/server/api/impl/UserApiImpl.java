package cn.jbone.sys.server.api.impl;

import cn.jbone.common.dataobject.PagedResponseDO;
import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.common.UserRequestDO;
import cn.jbone.sys.common.UserResponseDO;
import cn.jbone.sys.common.dto.request.ChangePasswordRequestDTO;
import cn.jbone.sys.common.dto.request.GithubUserLoginRequestDTO;
import cn.jbone.sys.common.dto.response.UserSecurityQuestionsResponseDTO;
import cn.jbone.sys.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserApiImpl implements UserApi {

    private Logger logger = LoggerFactory.getLogger(UserApiImpl.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserSecurityQuestions")
    public Result<List<UserSecurityQuestionsResponseDTO>> getUserSecurityQuestions(String username) {
        List<UserSecurityQuestionsResponseDTO> responseDTOList = null;
        try {
            responseDTOList = userService.findUserSecurityQuestions(username);
            if(responseDTOList == null){
                return Result.wrap404Error("securityQuestions is not found");
            }
        } catch (Exception e) {
            logger.warn("getUserSecurityQuestions error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(responseDTOList);
    }

    @Override
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Void> changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO) {
        try {
            userService.modifyPassword(changePasswordRequestDTO);
        } catch (Exception e) {
            logger.warn("modify password error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    @RequestMapping(value = "/thirdPartyUserLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Void> thirdPartyUserLogin(@RequestBody GithubUserLoginRequestDTO githubUserLoginRequestDTO) {
        try {
            userService.thirdPartyLogin(githubUserLoginRequestDTO);
        } catch (Exception e) {
            logger.warn("third party login error.",e);
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess();
    }

    @Override
    @RequestMapping(value = "/commonRequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<UserResponseDO> commonRequest(@RequestBody UserRequestDO userRequestDO) {
        UserResponseDO userResponseDO = null;
        try {
            userResponseDO = userService.commonRequest(userRequestDO);
            if(userResponseDO == null){
                return Result.wrap404Error("用户未找到");
            }
        } catch (NoSuchElementException e) {
            return Result.wrap404Error("用户未找到");
        } catch(Exception e){
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(userResponseDO);
    }

    @Override
    @RequestMapping(value = "/commonSearch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<PagedResponseDO<UserResponseDO>> commonSearch(@RequestBody UserRequestDO userRequestDO) {
        PagedResponseDO<UserResponseDO> pagedResponseDO = null;
        try {
            pagedResponseDO = userService.commonSearch(userRequestDO);
        } catch (NoSuchElementException e) {
            return Result.wrap404Error("用户未找到");
        } catch(Exception e){
            return Result.wrap500Error(e.getMessage());
        }
        return Result.wrapSuccess(pagedResponseDO);
    }
}
