package cn.jbone.errors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JboneErrorsPageConfiguration {
    @Bean
    public JboneErrorPageRegister getJboneErrorPageRigister(){
        return new JboneErrorPageRegister();
    }


}
