package com.visher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@SpringBootApplication
public class SpringBeanScopeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBeanScopeApplication.class);
    }
    @Bean
    @Scope("singleton")
    public SingletonBean personSingleton() {
        return new SingletonBean();
    }

//    @Bean
//    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
//    public HelloMessageGenerator requestScopedBean() {
//        return new HelloMessageGenerator();
//    }

    @Bean
    @SessionScope
    public HelloMessageGenerator sessionScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @RequestScope
    public HelloMessageGenerator requestScopedBean() {
        return new HelloMessageGenerator();
    }

    @Bean
    @Scope("prototype")
    public PrototypeBean studentPrototype() {
        return new PrototypeBean();
    }
}
