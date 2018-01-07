package org.apereo.cas.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class SpringManager implements ApplicationListener<ContextRefreshedEvent> {
    private static ApplicationContext applicationContext = null;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if(applicationContext == null){
            applicationContext = contextRefreshedEvent.getApplicationContext();
        }
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
