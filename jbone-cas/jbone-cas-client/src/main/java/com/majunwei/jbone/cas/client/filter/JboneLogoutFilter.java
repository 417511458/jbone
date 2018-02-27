package com.majunwei.jbone.cas.client.filter;

import com.majunwei.jbone.cas.client.session.JboneCasSessionDao;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Iterator;
import java.util.Set;

public class JboneLogoutFilter extends LogoutFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private StringRedisTemplate redisTemplate;
    public JboneLogoutFilter(StringRedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * 在注销前，清除其他系统的session
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        try {
            Subject subject = this.getSubject(request, response);
            String sessionId = subject.getSession().getId().toString();
            ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
            String userId = valueOperations.get(JboneCasFilter.SESSION_USERID_PREFIX + sessionId);
            logger.info("logout [sessionId:{};userId:{}]",sessionId,userId);

            if(StringUtils.isNotBlank(userId)){
                SetOperations<String,String> setOperations = redisTemplate.opsForSet();
                Set<String> sessionIds = setOperations.members(JboneCasFilter.USERID_SESSION_PREFIX + userId);
                Iterator<String> iterator = sessionIds.iterator();
                while (iterator.hasNext()){
                    String sid = iterator.next();
                    //删除session
                    redisTemplate.delete(JboneCasSessionDao.SESSION_KEY + sid);
                    //删除session_userId
                    redisTemplate.delete(JboneCasFilter.SESSION_USERID_PREFIX + sid);
                }
                //删除userId
                redisTemplate.delete(JboneCasFilter.USERID_SESSION_PREFIX + userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.preHandle(request, response);
    }
}
