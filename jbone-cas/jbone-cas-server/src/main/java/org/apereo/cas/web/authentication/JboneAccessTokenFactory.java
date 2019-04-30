package org.apereo.cas.web.authentication;

import cn.jbone.cas.common.JboneToken;
import cn.jbone.sys.common.UserResponseDO;
import org.apereo.cas.authentication.Authentication;
import org.apereo.cas.authentication.principal.Service;
import org.apereo.cas.ticket.ExpirationPolicy;
import org.apereo.cas.ticket.TicketGrantingTicket;
import org.apereo.cas.ticket.UniqueTicketIdGenerator;
import org.apereo.cas.ticket.accesstoken.AccessToken;
import org.apereo.cas.ticket.accesstoken.DefaultAccessTokenFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JboneAccessTokenFactory extends DefaultAccessTokenFactory {

    RedisTemplate<String, JboneToken> redisTemplate;

    public JboneAccessTokenFactory(ExpirationPolicy expirationPolicy) {
        super(expirationPolicy);
    }

    public JboneAccessTokenFactory(UniqueTicketIdGenerator accessTokenIdGenerator, ExpirationPolicy expirationPolicy,RedisTemplate<String, JboneToken> redisTemplate) {
        super(accessTokenIdGenerator, expirationPolicy);
        this.redisTemplate = redisTemplate;
    }

    @Override
    public AccessToken create(Service service, Authentication authentication, TicketGrantingTicket ticketGrantingTicket, Collection<String> scopes) {
        AccessToken accessToken = super.create(service, authentication, ticketGrantingTicket, scopes);
        JboneToken jboneToken = new JboneToken();
        jboneToken.setId(accessToken.getId());
        jboneToken.setCreationTime(new Date().getTime());
        jboneToken.setTimeout(accessToken.getExpirationPolicy().getTimeToLive());

        Map<String,Object> attributes = ticketGrantingTicket.getAuthentication().getPrincipal().getAttributes();
        UserResponseDO userResponseDO = (UserResponseDO) ((List) attributes.get("userInfo")).get(0);
        jboneToken.setUserResponseDO(userResponseDO);
        this.redisTemplate.opsForValue().set(JboneToken.PREFIX + accessToken.getId(),jboneToken,accessToken.getExpirationPolicy().getTimeToLive(), TimeUnit.SECONDS);
        return accessToken;
    }
}
