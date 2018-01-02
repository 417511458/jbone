package com.majunwei.jbone.cas.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.springframework.stereotype.Component;

@Component
public class JboneCasSessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext sessionContext) {
        JboneCasSession session = new JboneCasSession();
        return session;
    }
}
