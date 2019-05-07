package cn.jbone.sm.gateway.filters;

import cn.jbone.common.rpc.Result;
import cn.jbone.sm.gateway.constants.GatewayConstants;
import cn.jbone.sm.gateway.token.TokenRepository;
import cn.jbone.sys.common.UserResponseDO;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserInfoFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    private TokenRepository tokenRepository;
    public  UserInfoFilter(){}
    public UserInfoFilter(TokenRepository tokenRepository){
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String requestUri = requestContext.getRequest().getRequestURI();
        if(requestUri.equals(GatewayConstants.CURRENT_USER_URI)){
            UserResponseDO userInfo = tokenRepository.get(requestContext.get(GatewayConstants.TOKEN_KEY).toString()).getUserResponseDO();
            if(userInfo == null){
                return null;
            }

            //拷贝后再返回，去掉密码等敏感信息
            UserResponseDO userResponseDO = new UserResponseDO();
            userResponseDO.setAuthInfo(userInfo.getAuthInfo());
            userResponseDO.setBaseInfo(userInfo.getBaseInfo());

            requestContext.getResponse().setContentType("text/html;charset=UTF-8");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(200);
            requestContext.setResponseBody(JSON.toJSONString(new Result<>(userResponseDO)));
        }
        return null;
    }

}
