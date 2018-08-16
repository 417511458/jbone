package org.apereo.cas.web.listener;

import cn.jbone.sys.api.UserApi;
import cn.jbone.sys.api.dto.ThirdPartyName;
import cn.jbone.sys.api.dto.request.GithubUserLoginRequestDTO;
import org.apache.commons.lang3.StringUtils;
import org.apereo.cas.authentication.principal.SimplePrincipal;
import org.apereo.cas.support.events.ticket.CasTicketGrantingTicketCreatedEvent;
import org.apereo.cas.ticket.TicketGrantingTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TGT创建监听器，用于三方登录
 */
@Component
public class CasTicketGrantingTicketCreatedEventListener implements ApplicationListener<CasTicketGrantingTicketCreatedEvent> {
    @Autowired
    UserApi userApi;

    Logger logger = LoggerFactory.getLogger(CasTicketGrantingTicketCreatedEventListener.class);

    @Override
    public void onApplicationEvent(CasTicketGrantingTicketCreatedEvent event) {
        try {
            TicketGrantingTicket ticketGrantingTicket =  event.getTicketGrantingTicket();
            SimplePrincipal principal = (SimplePrincipal) ticketGrantingTicket.getAuthentication().getPrincipal();

            Map<String,Object> authAttributes = ticketGrantingTicket.getAuthentication().getAttributes();

            String clientName = String.valueOf(authAttributes.get("clientName"));
            if(StringUtils.isBlank(clientName)){
                return;
            }
            Map<String,Object> principalAttributes = principal.getAttributes();
            String id = principal.getId();
            thirdPartyUser(id,principalAttributes,clientName);
        } catch (Exception e) {
            logger.warn("third party login fail.",e);
        }
    }

    private void thirdPartyUser(String id,Map<String,Object> attributes,String clientName){
        //Github账号登录返回参考  https://api.github.com/users/417511458
        if(clientName.equalsIgnoreCase(ThirdPartyName.GITHUB.toString())){
            GithubUserLoginRequestDTO requestDTO = new GithubUserLoginRequestDTO();

            String avatarUrl = attributes.get("avatar_url") == null ? null : attributes.get("avatar_url").toString();
            String blog = attributes.get("blog") == null ? null : attributes.get("blog").toString();
            String company = attributes.get("company") == null ? null : attributes.get("company").toString();
            String email = attributes.get("email") == null ? null : attributes.get("email").toString();
            String htmlUrl = attributes.get("html_url") == null ? null : attributes.get("html_url").toString();
            String login = attributes.get("login") == null ? null : attributes.get("login").toString();
            String name = attributes.get("name") == null ? null : attributes.get("name").toString();
            String nodeId = attributes.get("node_id") == null ? null : attributes.get("node_id").toString();



            requestDTO.setAvatarUrl(avatarUrl);
            requestDTO.setBlog(blog);
            requestDTO.setCompany(company);
            requestDTO.setEmail(email);
            requestDTO.setHtmlUrl(htmlUrl);
            requestDTO.setLogin(login);
            requestDTO.setName(name);
            requestDTO.setNodeId(nodeId);
            requestDTO.setId(id);
            requestDTO.setThirdPartyName(ThirdPartyName.GITHUB);

            userApi.thirdPartyUserLogin(requestDTO);
        }

    }
}
