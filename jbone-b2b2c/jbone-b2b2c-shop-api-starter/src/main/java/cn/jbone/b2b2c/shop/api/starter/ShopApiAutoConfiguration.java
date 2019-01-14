package cn.jbone.b2b2c.shop.api.starter;

import cn.jbone.b2b2c.shop.api.ShopReadApi;
import cn.jbone.configuration.JboneConfiguration;
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
public class ShopApiAutoConfiguration {
    @Autowired
    JboneConfiguration jboneConfiguration;

    @Bean
    public ShopReadApi getShopReadApi(Decoder decoder, Encoder encoder, Client client){
        ShopReadApi shopReadApi = HystrixFeign.builder().client(client).setterFactory(getCommandSetter())
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(ShopReadApi.class, jboneConfiguration.getRpc().getShopServer().getFeign().getProtocol() + "://" + jboneConfiguration.getRpc().getShopServer().getFeign().getName().toUpperCase(),getShopReadApiFallbackFactory());
        return shopReadApi;
    }

    @Bean
    public ShopReadApiFallbackFactory getShopReadApiFallbackFactory(){
        return new ShopReadApiFallbackFactory();
    }

    /**
     * Hystrix熔断配置工厂
     * @return
     */
    @Bean
    public SetterFactory getCommandSetter(){
        String sysname = jboneConfiguration.getSys().getServerName();
        String groupKey = sysname + "." + ShopReadApi.class.getSimpleName();//组名（系统名.类名）用户分组统计Hystrix线程池
        SetterFactory setterFactory = new SetterFactory() {
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                HystrixCommand.Setter commandSetter = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey));
                com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand anno = method.getAnnotation(com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand.class);
                if(anno != null){
                    String commandKey = null;//命令（类名.方法名)，hystrix dashboard会自动拼接成：系统名.类名.方法名
                    if(StringUtils.isNotBlank(anno.commandKey())){
                        commandKey = ShopReadApi.class.getSimpleName() + "." + anno.commandKey();

                    }else{
                        commandKey = ShopReadApi.class.getSimpleName() + "." + method.getName();
                    }
                    commandSetter.andCommandKey(HystrixCommandKey.Factory.asKey(commandKey));

                }
                return commandSetter;
            }
        };
        return setterFactory;
    }
}
