package cn.jbone.sys.api.feign;

import cn.jbone.configuration.JboneConfiguration;
import cn.jbone.sys.api.UserApi;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import feign.Client;
import feign.Target;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Method;

@Configuration
@Import(FeignClientsConfiguration.class)
public class JboneSysApiFeignConfiguration {
    @Autowired
    JboneConfiguration jboneConfiguration;

    @Bean
    public UserApi getUserApi(Decoder decoder, Encoder encoder, Client client){
        UserApi userApi = HystrixFeign.builder().client(client).setterFactory(getCommandSetter())
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(UserApi.class, jboneConfiguration.getRpc().getSysServer().getFeign().getProtocol() + "://" + jboneConfiguration.getRpc().getSysServer().getFeign().getName().toUpperCase(),getUserApiFallbackFactory());
        return userApi;
    }

    @Bean
    public UserApiFallbackFactory getUserApiFallbackFactory(){
        return new UserApiFallbackFactory();
    }

    /**
     * Hystrix熔断配置工厂
     * @return
     */
    @Bean
    public SetterFactory getCommandSetter(){
        String sysname = jboneConfiguration.getSys().getServerName();
        String groupKey = sysname + "." + UserApi.class.getSimpleName();//组名（系统名.类名）用户分组统计Hystrix线程池
        SetterFactory setterFactory = new SetterFactory() {
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                HystrixCommand.Setter commandSetter = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey));
                com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand anno = method.getAnnotation(com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand.class);
                if(anno != null){
                    String commandKey = null;//命令（类名.方法名)，hystrix dashboard会自动拼接成：系统名.类名.方法名
                    if(StringUtils.isNotBlank(anno.commandKey())){
                        commandKey = UserApi.class.getSimpleName() + "." + anno.commandKey();

                    }else{
                        commandKey = UserApi.class.getSimpleName() + "." + method.getName();
                    }
                    commandSetter.andCommandKey(HystrixCommandKey.Factory.asKey(commandKey));

                }
                return commandSetter;
            }
        };
        return setterFactory;
    }

}
