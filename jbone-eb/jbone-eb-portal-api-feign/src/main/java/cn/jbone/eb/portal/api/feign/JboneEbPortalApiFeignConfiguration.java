package cn.jbone.eb.portal.api.feign;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.eb.portal.api.OperationPositionApi;
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
public class JboneEbPortalApiFeignConfiguration {
    @Autowired
    JboneConfiguration jboneConfiguration;

    @Bean
    public OperationPositionApi getOperationPositionApi(Decoder decoder, Encoder encoder, Client client){
        OperationPositionApi operationPositionApi = Feign.builder().client(client)
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(OperationPositionApi.class, jboneConfiguration.getRpc().getEbPortalServer().getFeign().getProtocol() + "://" + jboneConfiguration.getRpc().getEbPortalServer().getFeign().getName().toUpperCase());
        return operationPositionApi;
    }
}
