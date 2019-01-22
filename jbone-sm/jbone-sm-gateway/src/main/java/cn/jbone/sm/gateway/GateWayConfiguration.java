package cn.jbone.sm.gateway;

import cn.jbone.cas.client.session.JboneCasSessionDao;
import cn.jbone.cas.client.session.JboneSessionTicketStore;
import cn.jbone.sm.gateway.filters.TokenFilter;
import io.buji.pac4j.context.ShiroSessionStore;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 跨域配置
 */
@Configuration
public class GateWayConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 允许cookies跨域
        config.addAllowedOrigin("*");// #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
        config.addAllowedHeader("*");// #允许访问的头信息,*表示全部
        config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public TokenFilter tokenFilter(JboneCasSessionDao jboneCasSessionDao){
        return new TokenFilter(jboneCasSessionDao);
    }

    @Bean(name = "jboneCasSessionDao")
    public JboneCasSessionDao getSessionDao(StringRedisTemplate redisTemplate){
        JboneCasSessionDao sessionDao = new JboneCasSessionDao(redisTemplate);
        return sessionDao;
    }

}
