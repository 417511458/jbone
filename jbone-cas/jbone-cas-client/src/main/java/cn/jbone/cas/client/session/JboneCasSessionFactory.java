package cn.jbone.cas.client.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

/**
 * Session生成器
 */
public class JboneCasSessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext sessionContext) {
        JboneCasSession session = new JboneCasSession();
        return session;
    }
}
