package cn.jbone.sys.api;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.dto.request.ChangePasswordRequestDTO;
import cn.jbone.sys.api.dto.response.UserBaseInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserSecurityQuestionsResponseDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/user")
public interface UserApi {
    @RequestMapping(value = "/getUserByName")
    Result<UserBaseInfoResponseDTO> getUserByName(@RequestParam("username") String username);

    @RequestMapping(value = "/getUserDetail")
    Result<UserInfoResponseDTO> getUserDetailByName(@RequestParam("username") String username);

    @RequestMapping(value = "/getUserDetailByNameAndServerName")
    Result<UserInfoResponseDTO> getUserDetailByNameAndServerName(@RequestParam("username") String username, @RequestParam("serverName") String serverName);

    @RequestMapping(value = "/getUserSecurityQuestions")
    Result<List<UserSecurityQuestionsResponseDTO>> getUserSecurityQuestions(@RequestParam("username") String username);

    @RequestMapping(value = "/changePassword")
    Result<Void> changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO);
}
