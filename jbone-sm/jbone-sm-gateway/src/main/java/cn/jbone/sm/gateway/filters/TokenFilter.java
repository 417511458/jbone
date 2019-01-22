package cn.jbone.sm.gateway.filters;

import cn.jbone.cas.client.session.JboneCasSession;
import cn.jbone.cas.client.session.JboneCasSessionDao;
import cn.jbone.common.rpc.Result;
import cn.jbone.sys.common.UserResponseDO;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.shiro.session.UnknownSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends ZuulFilter {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    public final static String TOKEN = "token";
    public final static String SESSION = "session";
    public final static String USER = "user";


    private JboneCasSessionDao sessionDao;

    public TokenFilter(){}
    public TokenFilter(JboneCasSessionDao sessionDao){
        this.sessionDao = sessionDao;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String token = request.getParameter(TOKEN);


        JboneCasSession session = null;
        try {
            session = (JboneCasSession) sessionDao.readSession(token);
        } catch (UnknownSessionException e) {
            authErrorSession(requestContext,token);
            return null;
        }
        if(session == null){
            authErrorSession(requestContext,token);
            return null;
        }

        if(!session.getHost().equals(request.getRemoteHost())){
            logger.info("host is not mached.session host:{},remoteHost:{}",session.getHost(),request.getRemoteHost());
            authErrorSession(requestContext,token);
            return null;
        }

        logger.info("session: " + session.toString());


        requestContext.set(TOKEN,token);

        //将用户信息保存到上下文
        UserResponseDO userModel = session.getUserInfo();
        requestContext.set(USER,userModel);
        return null;
    }

    private void authErrorSession(RequestContext requestContext,String token){
        logger.info("token is not found: {}",token);
        requestContext.getResponse().setContentType("text/html;charset=UTF-8");
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(401);
        requestContext.setResponseBody(JSON.toJSONString(Result.wrapError(401,"没有权限")));
    }
}
