package com.majunwei.jbone.sys.api.feign;

import com.majunwei.jbone.configuration.JboneConfiguration;
import com.majunwei.jbone.sys.api.UserApi;
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
                .target(UserApi.class, jboneConfiguration.getSys().getServerProtol() + jboneConfiguration.getSys().getServerName().toUpperCase());
        return userApi;
    }
}
