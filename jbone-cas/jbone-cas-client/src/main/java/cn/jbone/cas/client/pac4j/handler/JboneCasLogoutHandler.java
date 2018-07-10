package cn.jbone.cas.client.pac4j.handler;

import cn.jbone.cas.client.session.JboneSessionTicketStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.pac4j.cas.logout.DefaultCasLogoutHandler;
import org.pac4j.core.context.WebContext;
import org.pac4j.core.context.session.SessionStore;
import org.pac4j.core.profile.ProfileManager;

import java.io.Serializable;

/**
 * Jbone单点登出
 * @param <C>
 */
public class JboneCasLogoutHandler<C extends WebContext> extends DefaultCasLogoutHandler<C> {


    public JboneCasLogoutHandler(JboneSessionTicketStore sessionTicketStore){
        this.sessionTicketStore = sessionTicketStore;
    }
    private JboneSessionTicketStore sessionTicketStore;


    private SessionManager sessionManager;

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    /**
     * 记录当前的Session和ticket关系，用于回调destroySessionBack时单点登出，销毁用户Session
     */
    @Override
    public void recordSession(C context, String ticket) {
        SessionStore sessionStore = context.getSessionStore();
        if (sessionStore == null) {
            logger.error("No session store available for this web context");
        } else {
            String sessionId = sessionStore.getOrCreateSessionId(context);
            if(StringUtils.isNotBlank(sessionId)){
                sessionTicketStore.store(sessionId,ticket);
            }
        }
    }

    /**
     * cas认证中心回调此方法，用于销毁当前系统ticket对于的Session,从而注销用户
     * @param context
     * @param ticket
     */
    @Override
    public void destroySessionBack(C context, String ticket) {
        destroySession(context,ticket);
    }

    /**
     * 销毁Session
     * @param context
     * @param ticket
     */
    public void destroySession(C context, final String ticket) {
        ProfileManager manager = new ProfileManager(context);
        manager.logout();

        Serializable sessionId = sessionTicketStore.getSessionId(ticket);
        if (sessionId != null) {
            try {
                Session session = sessionManager.getSession(new DefaultSessionKey(sessionId));
                session.stop();
            } catch (Exception e) {
                logger.warn(e.getMessage());
            }
        }
        sessionTicketStore.deleteByTicket(ticket);
    }
}
