package cn.jbone.sm.gateway.token;

import cn.jbone.sso.common.token.JboneToken;
import cn.jbone.sm.gateway.constants.GatewayConstants;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class TokenRepository {

    RedisTemplate<String, JboneToken> redisTemplate;

    public TokenRepository(){}
    public TokenRepository(RedisTemplate<String, JboneToken> redisTemplate){
        this.redisTemplate = redisTemplate;
    }


    public JboneToken get(String token){
        //先判断有没有单点登出过
        if(!redisTemplate.hasKey(GatewayConstants.CAS_TICKET_PREFIX + token)){
            return null;
        }
        return redisTemplate.opsForValue().get(JboneToken.PREFIX + token);
    }

    public JboneToken getAndRefresh(String token){
        JboneToken jboneToken = get(token);
        if(jboneToken == null){
            return null;
        }
        //同时刷新jbonetoken和castoken，防止token失效
        redisTemplate.expire(JboneToken.PREFIX + token,jboneToken.getTimeout(), TimeUnit.SECONDS);
        redisTemplate.expire(GatewayConstants.CAS_TICKET_PREFIX + token,jboneToken.getTimeout(), TimeUnit.SECONDS);
        return jboneToken;
    }
}
