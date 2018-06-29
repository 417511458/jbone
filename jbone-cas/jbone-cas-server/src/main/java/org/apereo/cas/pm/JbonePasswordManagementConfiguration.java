package org.apereo.cas.pm;

import cn.jbone.sys.api.UserApi;
import org.apereo.cas.CipherExecutor;
import org.apereo.cas.configuration.CasConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("JbonePasswordManagementConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class JbonePasswordManagementConfiguration {

    @Autowired
    private CasConfigurationProperties casProperties;

    @Autowired
    @Qualifier("passwordManagementCipherExecutor")
    private CipherExecutor passwordManagementCipherExecutor;

    @Autowired
    private UserApi userApi;

    @Bean(name="passwordChangeService")
    public PasswordManagementService passwordChangeService(){
        return new JbonePasswordManagementService(passwordManagementCipherExecutor,casProperties.getServer().getPrefix(),
                casProperties.getAuthn().getPm(),userApi);
    }
}
