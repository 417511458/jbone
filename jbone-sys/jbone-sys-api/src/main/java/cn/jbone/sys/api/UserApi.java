package cn.jbone.sys.api;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.common.UserRequestDO;
import cn.jbone.sys.common.UserResponseDO;
import cn.jbone.sys.common.dto.request.ChangePasswordRequestDTO;
import cn.jbone.sys.common.dto.request.GithubUserLoginRequestDTO;
import cn.jbone.sys.common.dto.response.UserBaseInfoResponseDTO;
import cn.jbone.sys.common.dto.response.UserInfoResponseDTO;
import cn.jbone.sys.common.dto.response.UserSecurityQuestionsResponseDTO;
import feign.Headers;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@RequestMapping("/user")
public interface UserApi {

    @RequestMapping(value = "/getUserByName",method = {RequestMethod.GET})
    Result<UserBaseInfoResponseDTO> getUserByName(@RequestParam("username") String username);

    @RequestMapping(value = "/getUserDetail",method = {RequestMethod.GET})
    Result<UserInfoResponseDTO> getUserDetailByName(@RequestParam("username") String username);

    @RequestMapping(value = "/getUserDetailByNameAndServerName",method = {RequestMethod.GET})
    Result<UserInfoResponseDTO> getUserDetailByNameAndServerName(@RequestParam("username") String username, @RequestParam("serverName") String serverName);

    @RequestMapping(value = "/getUserSecurityQuestions",method = {RequestMethod.GET})
    Result<List<UserSecurityQuestionsResponseDTO>> getUserSecurityQuestions(@RequestParam("username") String username);

    @RequestMapping(value = "/changePassword",method = {RequestMethod.POST})
    Result<Void> changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO);

    @RequestMapping(value = "/thirdPartyUserLogin",method = {RequestMethod.POST})
    Result<Void> thirdPartyUserLogin(@RequestBody GithubUserLoginRequestDTO githubUserLoginRequestDTO);

    @RequestMapping(value = "/commonRequest",method = {RequestMethod.POST},consumes = MediaType.APPLICATION_JSON_VALUE)
    @Headers("Content-Type: application/json")
    Result<UserResponseDO> commonRequest(@RequestBody UserRequestDO userRequestDO);
}
