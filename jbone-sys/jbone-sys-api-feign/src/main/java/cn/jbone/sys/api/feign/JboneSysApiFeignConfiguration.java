package cn.jbone.sys.api.feign;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sys.api.UserApi;
import feign.Client;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FeignClientsConfiguration.class)
public class JboneSysApiFeignConfiguration {
    @Autowired
    JboneConfiguration jboneConfiguration;

    @Bean
    public UserApi getUserApi(Decoder decoder, Encoder encoder, Client client){
        UserApi userApi = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(UserApi.class, jboneConfiguration.getRpc().getSysServer().getFeign().getProtocol() + "://" + jboneConfiguration.getRpc().getSysServer().getFeign().getName().toUpperCase());
        return userApi;
    }
}
