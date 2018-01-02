package com.majunwei.jbone.cas.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 监听器
 * @author majunwei
 */
@Component
public class JboneCasSessionListener implements SessionListener {

    private Logger logger = LoggerFactory.getLogger(JboneCasSessionListener.class);

    @Override
    public void onStart(Session session) {
        logger.debug("新会话 {}",session.getId());
    }

    @Override
    public void onStop(Session session) {
        logger.debug("会话结束 {}",session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        logger.debug("会话过期 {}",session.getId());
    }
}
