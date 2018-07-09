package cn.jbone.cas.client.session;

import cn.jbone.cas.client.utils.SerializableUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Session持久化
 *
 * @author majunwei
 */
public class JboneCasSessionDao extends CachingSessionDAO {

    private Logger logger = LoggerFactory.getLogger(JboneCasSessionDao.class);

    public JboneCasSessionDao(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    StringRedisTemplate redisTemplate;

    public static final String SESSION_KEY = "jbone_session_";
    private JboneSessionTicketStore sessionTicketStore;

    public JboneSessionTicketStore getSessionTicketStore() {
        return sessionTicketStore;
    }

    public void setSessionTicketStore(JboneSessionTicketStore sessionTicketStore) {
        this.sessionTicketStore = sessionTicketStore;
    }

    @Override
    protected void doUpdate(Session session) {
        // 如果会话过期/停止 没必要再更新了
        if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
            return;
        }
        String sessionId = session.getId().toString();
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set(SESSION_KEY + sessionId, SerializableUtil.serialize(session),session.getTimeout(), TimeUnit.MILLISECONDS);

        sessionTicketStore.expireBySession(sessionId);
    }

    @Override
    protected void doDelete(Session session) {
        String sessionId = session.getId().toString();
        redisTemplate.delete(SESSION_KEY + sessionId);

        sessionTicketStore.deleteBySession(sessionId);
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set(SESSION_KEY + sessionId, SerializableUtil.serialize(session),session.getTimeout(), TimeUnit.MILLISECONDS);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable serializable) {
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        String session = operations.get(SESSION_KEY + serializable);
        return SerializableUtil.deserialize(session);
    }
}
