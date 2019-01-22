package cn.jbone.sm.gateway.filters;

import cn.jbone.cas.client.session.JboneCasSession;
import cn.jbone.cas.client.session.JboneCasSessionDao;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
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


        JboneCasSession session = (JboneCasSession) sessionDao.readSession(token);
        if(session == null){
            logger.info("token is not found: {}",token);
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            return null;
        }

        requestContext.set(TOKEN,token);
        requestContext.set(SESSION,session);

        logger.info("session: " + session.toString());
        return null;
    }
}
