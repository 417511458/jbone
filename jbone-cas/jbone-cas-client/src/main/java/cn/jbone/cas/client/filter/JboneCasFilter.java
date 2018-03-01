package cn.jbone.cas.client.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.concurrent.TimeUnit;

public class JboneCasFilter extends CasFilter {

    private Logger logger = LoggerFactory.getLogger(JboneCasFilter.class);

    public static String USERID_SESSION_PREFIX = "userid_session_";
    public static String SESSION_USERID_PREFIX = "session_userid_";

    private StringRedisTemplate redisTemplate;
    public JboneCasFilter(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * 登录成功后，记录user和session的关系，用于单点登出时，一处登出，销毁user对应的所有session
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        try {
            CasToken casToken = (CasToken)token;
            String userId = casToken.getPrincipal().toString();
            String sessionId = subject.getSession().getId().toString();
            SetOperations<String,String> operation= redisTemplate.opsForSet();
            operation.add(USERID_SESSION_PREFIX + userId,sessionId);

            ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(SESSION_USERID_PREFIX + sessionId,userId);

            redisTemplate.expire(SESSION_USERID_PREFIX + sessionId,8, TimeUnit.HOURS);
            redisTemplate.expire(USERID_SESSION_PREFIX + userId,8, TimeUnit.HOURS);

            logger.info("save ticket and session[userId:{},sessionId:{}]",userId,sessionId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.onLoginSuccess(token, subject, request, response);
    }
}
