package cn.jbone.cms.api.starter;

import cn.jbone.cms.api.*;
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
public class JboneCmsApiStarterConfiguration {
    @Autowired
    JboneConfiguration jboneConfiguration;

    @Bean
    public ArticleApi getArticleApi(Decoder decoder, Encoder encoder, Client client){
        ArticleApi articleApi = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(ArticleApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(ArticleApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getArticleApiFallbackFactory());
        return articleApi;
    }

    @Bean
    public CategoryApi getCategoryApi(Decoder decoder, Encoder encoder, Client client){
        CategoryApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(CategoryApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(CategoryApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getCategoryApiFallbackFactory());
        return api;
    }

    @Bean
    public CategoryTocApi getCategoryTocApi(Decoder decoder, Encoder encoder, Client client){
        CategoryTocApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(CategoryTocApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(CategoryTocApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getCategoryTocApiFallbackFactory());
        return api;
    }

    @Bean
    public LinkApi getLinkApi(Decoder decoder, Encoder encoder, Client client){
        LinkApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(LinkApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(LinkApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getLinkApiFallbackFactory());
        return api;
    }

    @Bean
    public SettingsApi getSettingsApi(Decoder decoder, Encoder encoder, Client client){
        SettingsApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(SettingsApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(SettingsApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getSettingsApiFallbackFactory());
        return api;
    }

    @Bean
    public StatisticsApi getStatisticsApi(Decoder decoder, Encoder encoder, Client client){
        StatisticsApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(StatisticsApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(StatisticsApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getStatisticsApiFallbackFactory());
        return api;
    }

    @Bean
    public TagApi getTagApi(Decoder decoder, Encoder encoder, Client client){
        TagApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(TagApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(TagApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getTagApiFallbackFactory());
        return api;
    }

    @Bean
    public TemplateApi getTemplateApi(Decoder decoder, Encoder encoder, Client client){
        TemplateApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(TemplateApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(TemplateApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getTemplateApiFallbackFactory());
        return api;
    }

    @Bean
    public CommentApi getCommentApi(Decoder decoder, Encoder encoder, Client client){
        CommentApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(CommentApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(CommentApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getCommentApiFallbackFactory());
        return api;
    }

    @Bean
    public DictionaryApi getDictionaryApi(Decoder decoder, Encoder encoder, Client client){
        DictionaryApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(DictionaryApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(DictionaryApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getDictionaryApiFallbackFactory());
        return api;
    }

    @Bean
    public PluginApi getPluginApi(Decoder decoder, Encoder encoder, Client client){
        PluginApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(PluginApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(PluginApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getPluginApiFallbackFactory());
        return api;
    }

    @Bean
    public AdvertisementApi getAdvertisementApi(Decoder decoder, Encoder encoder, Client client){
        AdvertisementApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(AdvertisementApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(AdvertisementApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getAdvertisementApiFallbackFactory());
        return api;
    }

    @Bean
    public SiteApi getSiteApi(Decoder decoder, Encoder encoder, Client client){
        SiteApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(SiteApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(SiteApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getSiteApiFallbackFactory());
        return api;
    }

    @Bean
    public SiteSettingsApi getSiteSettingsApi(Decoder decoder, Encoder encoder, Client client){
        SiteSettingsApi api = HystrixFeign.builder().client(client).setterFactory(getCommandSetter(SiteSettingsApi.class))
                .encoder(encoder)
                .decoder(decoder).contract(new SpringMvcContract())
                .target(SiteSettingsApi.class, jboneConfiguration.getRpc().getCmsServer().getProtocol() + "://" + jboneConfiguration.getRpc().getCmsServer().getName().toUpperCase(),getSiteSettingsApiFallbackFactory());
        return api;
    }


    @Bean
    public ArticleApiFallbackFactory getArticleApiFallbackFactory(){
        return new ArticleApiFallbackFactory();
    }

    @Bean
    public CategoryApiFallbackFactory getCategoryApiFallbackFactory(){
        return new CategoryApiFallbackFactory();
    }

    @Bean
    public CategoryTocApiFallbackFactory getCategoryTocApiFallbackFactory(){
        return new CategoryTocApiFallbackFactory();
    }

    @Bean
    public LinkApiFallbackFactory getLinkApiFallbackFactory(){
        return new LinkApiFallbackFactory();
    }

    @Bean
    public SettingsApiFallbackFactory getSettingsApiFallbackFactory(){
        return new SettingsApiFallbackFactory();
    }

    @Bean
    public StatisticsApiFallbackFactory getStatisticsApiFallbackFactory(){
        return new StatisticsApiFallbackFactory();
    }

    @Bean
    public TagApiFallbackFactory getTagApiFallbackFactory(){
        return new TagApiFallbackFactory();
    }

    @Bean
    public TemplateApiFallbackFactory getTemplateApiFallbackFactory(){
        return new TemplateApiFallbackFactory();
    }

    @Bean
    public CommentApiFallbackFactory getCommentApiFallbackFactory(){
        return new CommentApiFallbackFactory();
    }

    @Bean
    public DictionaryApiFallbackFactory getDictionaryApiFallbackFactory(){
        return new DictionaryApiFallbackFactory();
    }

    @Bean
    public PluginApiFallbackFactory getPluginApiFallbackFactory(){
        return new PluginApiFallbackFactory();
    }

    @Bean
    public AdvertisementApiFallbackFactory getAdvertisementApiFallbackFactory(){
        return new AdvertisementApiFallbackFactory();
    }

    @Bean
    public SiteApiFallbackFactory getSiteApiFallbackFactory(){
        return new SiteApiFallbackFactory();
    }

    @Bean
    public SiteSettingsApiFallbackFactory getSiteSettingsApiFallbackFactory(){
        return new SiteSettingsApiFallbackFactory();
    }

    /**
     * Hystrix熔断配置工厂
     * @return
     */
    public SetterFactory getCommandSetter(Class cla){
        String sysname = jboneConfiguration.getSys().getServerName();
        String groupKey = sysname + "." + cla.getSimpleName();//组名（系统名.类名）用户分组统计Hystrix线程池
        SetterFactory setterFactory = new SetterFactory() {
            @Override
            public HystrixCommand.Setter create(Target<?> target, Method method) {
                HystrixCommand.Setter commandSetter = HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey));
                com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand anno = method.getAnnotation(com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand.class);
                if(anno != null){
                    String commandKey = null;//命令（类名.方法名)，hystrix dashboard会自动拼接成：系统名.类名.方法名
                    if(StringUtils.isNotBlank(anno.commandKey())){
                        commandKey = cla.getSimpleName() + "." + anno.commandKey();

                    }else{
                        commandKey = cla.getSimpleName() + "." + method.getName();
                    }
                    commandSetter.andCommandKey(HystrixCommandKey.Factory.asKey(commandKey));

                }
                return commandSetter;
            }
        };
        return setterFactory;
    }

}
