package cn.jbone.sm.gateway.filters;

import cn.jbone.common.rpc.Result;
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


    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String requestUri = requestContext.getRequest().getRequestURI();
        if(requestUri.equals("/system/getCurrentUser")){
            UserResponseDO userModel = (UserResponseDO) requestContext.get(TokenFilter.USER);

            //拷贝后再返回，去掉密码等敏感信息
            UserResponseDO userResponseDO = new UserResponseDO();
            userResponseDO.setAuthInfo(userModel.getAuthInfo());
            userResponseDO.setBaseInfo(userModel.getBaseInfo());

            requestContext.getResponse().setContentType("text/html;charset=UTF-8");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(200);
            requestContext.setResponseBody(JSON.toJSONString(new Result<>(userResponseDO)));
        }
        return null;
    }

}
