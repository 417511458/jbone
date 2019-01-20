package cn.jbone.sm.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
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

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Cookie[] cookies = request.getCookies();
        logger.info(cookies + "");
        Object token = request.getParameter("token");
        Object token2 = request.getParameter("jbone.session.id");
        logger.info("token:{}",token);
        logger.info("jbone.session.id:{}",token2);
        return null;
    }
}
