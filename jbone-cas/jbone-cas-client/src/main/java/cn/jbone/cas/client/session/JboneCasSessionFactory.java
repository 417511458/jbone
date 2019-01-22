package cn.jbone.cas.client.session;

import cn.jbone.configuration.JboneConfiguration;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

/**
 * Session生成器
 */
public class JboneCasSessionFactory implements SessionFactory {
    public JboneCasSessionFactory(){}

    private JboneConfiguration jboneConfiguration;
    public JboneCasSessionFactory(JboneConfiguration jboneConfiguration){
        this.jboneConfiguration = jboneConfiguration;
    }
    @Override
    public Session createSession(SessionContext sessionContext) {
        JboneCasSession session = new JboneCasSession();
        session.setServerName(jboneConfiguration.getSys().getServerName());
        session.setHost(sessionContext.getHost());
        return session;
    }
}
