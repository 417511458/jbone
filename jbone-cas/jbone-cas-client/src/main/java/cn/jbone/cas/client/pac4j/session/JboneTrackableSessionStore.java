package cn.jbone.cas.client.pac4j.session;

import org.apache.shiro.session.Session;

public class JboneTrackableSessionStore extends JboneSessionStore {

    private Session session;
    public JboneTrackableSessionStore(Session session) {
        this.session = session;
    }

    protected Session getSession(final boolean createSession) {
        return session;
    }
}
