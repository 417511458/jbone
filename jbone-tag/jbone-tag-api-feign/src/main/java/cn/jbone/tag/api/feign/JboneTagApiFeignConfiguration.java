package cn.jbone.tag.api.feign;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.tag.api.TagApi;
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

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 7:27
 */
@Configuration
@Import(FeignClientsConfiguration.class)
public class JboneTagApiFeignConfiguration {

    @Autowired
    JboneConfiguration jboneConfiguration;

    @Bean
    public TagApi getTagApi(Decoder decoder, Encoder encoder, Client client) {
        TagApi tagApi = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder)
                .contract(new SpringMvcContract())
                .target(TagApi.class, jboneConfiguration.getRpc().getTagServer().getFeign().getProtocol() + "://" + jboneConfiguration.getRpc().getTagServer().getFeign().getName().toUpperCase());
        return tagApi;
    }

}
