package cn.jbone.sys.api.feign;

import cn.jbone.common.rpc.Result;
import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.api.dto.request.ChangePasswordRequestDTO;
import cn.jbone.sys.api.dto.request.GithubUserLoginRequestDTO;
import cn.jbone.sys.api.dto.response.UserBaseInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserInfoResponseDTO;
import cn.jbone.sys.api.dto.response.UserSecurityQuestionsResponseDTO;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 用户API熔断器
 */
public class UserApiFallbackFactory implements FallbackFactory<UserApi> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public UserApi create(Throwable throwable) {

        return new UserApi() {
            @Override
            public Result<UserBaseInfoResponseDTO> getUserByName(String username) {
                logger.error("rpc getUserBaseInfo broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<UserInfoResponseDTO> getUserDetailByName(String username) {
                logger.error("rpc getUserDetailByName broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<UserInfoResponseDTO> getUserDetailByNameAndServerName(String username, String serverName) {
                logger.error("rpc getUserDetailByNameAndServerName broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<List<UserSecurityQuestionsResponseDTO>> getUserSecurityQuestions(String username) {
                logger.error("rpc getUserSecurityQuestions broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> changePassword(ChangePasswordRequestDTO changePasswordRequestDTO) {
                logger.error("rpc changePassword broke",throwable);
                return Result.wrapProtectedError();
            }

            @Override
            public Result<Void> thirdPartyUserLogin(GithubUserLoginRequestDTO githubUserLoginRequestDTO) {
                logger.error("rpc thirdPartyUserLogin broke",throwable);
                return Result.wrapProtectedError();
            }
        };
    }
}
