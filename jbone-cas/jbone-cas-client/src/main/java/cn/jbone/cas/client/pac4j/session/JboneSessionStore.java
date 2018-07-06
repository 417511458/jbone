package cn.jbone.cas.client.pac4j.session;

import io.buji.pac4j.context.ShiroSessionStore;
import org.apache.shiro.session.Session;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.session.SessionStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JboneSessionStore extends ShiroSessionStore {

    private Logger logger = LoggerFactory.getLogger(JboneSessionStore.class);

    @Override
    public boolean destroySession(J2EContext context) {
        return super.destroySession(context);
    }

    @Override
    public Object getTrackableSession(J2EContext context) {
        return getSession(true);
    }

    @Override
    public SessionStore<J2EContext> buildFromTrackableSession(J2EContext context, Object trackableSession) {
        if(trackableSession != null) {
            return new JboneTrackableSessionStore((Session) trackableSession);
        }
        return null;
    }

    @Override
    public boolean renewSession(J2EContext context) {
        return super.renewSession(context);
    }
}
