package com.majunwei.jbone.cas.shiro.session;

import com.majunwei.jbone.cas.utils.SerializableUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Session持久化
 *
 * @author majunwei
 */
@Component
public class JboneCasSessionDao extends CachingSessionDAO {

    private Logger logger = LoggerFactory.getLogger(JboneCasSessionDao.class);

    public static final String SESSION_KEY = "jbone_cas_session_";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    protected void doUpdate(Session session) {
        // 如果会话过期/停止 没必要再更新了
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return;
        }
        String sessionId = session.getId().toString();
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        ops.set(SESSION_KEY + sessionId, SerializableUtil.serialize(session),session.getTimeout(), TimeUnit.MILLISECONDS);
    }

    @Override
    protected void doDelete(Session session) {
        String sessionId = session.getId().toString();
        stringRedisTemplate.delete(SESSION_KEY + sessionId);
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        ops.set(SESSION_KEY + sessionId, SerializableUtil.serialize(session),session.getTimeout(), TimeUnit.MILLISECONDS);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        String session = ops.get(serializable);
        return SerializableUtil.deserialize(session);
    }
}
