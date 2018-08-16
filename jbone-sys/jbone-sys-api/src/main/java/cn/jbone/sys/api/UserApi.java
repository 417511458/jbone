package cn.jbone.sys.api;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.dto.request.ChangePasswordRequestDTO;
import cn.jbone.sys.api.dto.request.GithubUserLoginRequestDTO;
import cn.jbone.sys.api.dto.request.ThirdPartyUserLoginRequestDTO;
import cn.jbone.sys.api.dto.response.UserBaseInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserSecurityQuestionsResponseDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/user")
public interface UserApi {

    @HystrixCommand(commandKey = "getUserByName")
    @RequestMapping(value = "/getUserByName")
    Result<UserBaseInfoResponseDTO> getUserByName(@RequestParam("username") String username);

    @HystrixCommand(commandKey = "getUserDetailByName")
    @RequestMapping(value = "/getUserDetail")
    Result<UserInfoResponseDTO> getUserDetailByName(@RequestParam("username") String username);

    @HystrixCommand(commandKey = "getUserDetailByNameAndServerName")
    @RequestMapping(value = "/getUserDetailByNameAndServerName")
    Result<UserInfoResponseDTO> getUserDetailByNameAndServerName(@RequestParam("username") String username, @RequestParam("serverName") String serverName);

    @HystrixCommand(commandKey = "getUserSecurityQuestions")
    @RequestMapping(value = "/getUserSecurityQuestions")
    Result<List<UserSecurityQuestionsResponseDTO>> getUserSecurityQuestions(@RequestParam("username") String username);

    @HystrixCommand(commandKey = "changePassword")
    @RequestMapping(value = "/changePassword")
    Result<Void> changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO);

    @HystrixCommand(commandKey = "thirdPartyUserLogin")
    @RequestMapping(value = "/thirdPartyUserLogin")
    Result<Void> thirdPartyUserLogin(@RequestBody GithubUserLoginRequestDTO githubUserLoginRequestDTO);
}
