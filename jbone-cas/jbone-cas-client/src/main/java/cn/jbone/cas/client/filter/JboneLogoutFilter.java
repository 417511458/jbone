package cn.jbone.cas.client.filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.util.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class JboneLogoutFilter extends AdviceFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private StringRedisTemplate redisTemplate;
    public JboneLogoutFilter(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /** The name of the artifact parameter.  This is used to capture the session identifier. */
    private String artifactParameterName = "ticket";

    /** Parameter name that stores logout request */
    private String logoutParameterName = "logoutRequest";

    private SessionManager sessionManager;

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    /**
     * 在注销前，清除其他系统的session
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        try {
            HttpServletRequest req = (HttpServletRequest)request;
            if(isTokenRequest(req)){
                Session session = SecurityUtils.getSubject().getSession();
                final String token = CommonUtils.safeGetParameter(req, this.artifactParameterName);
                ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
                valueOperations.set(TOKEN_PREFIX + token,session.getId().toString());
                redisTemplate.expire(TOKEN_PREFIX + token,8, TimeUnit.HOURS);
                logger.info("save ticket and session[ticket:{},sessionId:{}]",token,session.getId().toString());
            }else if(isLogoutRequest(req)){
                invalidateSession(req,sessionManager);
                logger.info("logout");
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        if (session!=null&&session.getAttribute(logoutParameterName)!=null) {
            try {
                subject.logout();
            } catch (SessionException ise) {
                ise.printStackTrace();
            }
        }
        return true;
    }

    public boolean isTokenRequest(final HttpServletRequest request) {
        return CommonUtils.isNotBlank(CommonUtils.safeGetParameter(request, this.artifactParameterName));
    }

    public boolean isLogoutRequest(final HttpServletRequest request) {
        return "POST".equals(request.getMethod()) && !isMultipartRequest(request) &&
                CommonUtils.isNotBlank(CommonUtils.safeGetParameter(request, this.logoutParameterName));
    }

    private boolean isMultipartRequest(final HttpServletRequest request) {
        return request.getContentType() != null && request.getContentType().toLowerCase().startsWith("multipart");
    }

    private String TOKEN_PREFIX = "token_";


    public void invalidateSession(final HttpServletRequest request, final SessionManager sessionManager) {
        final String logoutMessage = CommonUtils.safeGetParameter(request, this.logoutParameterName);

        final String token = XmlUtils.getTextForElement(logoutMessage, "SessionIndex");
        if (CommonUtils.isNotBlank(token)) {
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            Serializable sessionId = valueOperations.get(TOKEN_PREFIX + token);
            if (sessionId != null) {
                try {
                    Session session = sessionManager.getSession(new DefaultSessionKey(sessionId));
                    if (session != null) {
                        //设置会话的logoutParameterName 属性表示无效了，这里直接使用了request的参数名
                        session.setAttribute(logoutParameterName, true);
                    }
                    session.stop();
                } catch (Exception e) {
                    logger.warn(e.getMessage());
//                    e.printStackTrace();
                }
            }
            redisTemplate.delete(TOKEN_PREFIX + token);
        }
    }
}
