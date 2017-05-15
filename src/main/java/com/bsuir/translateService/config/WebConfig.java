package com.bsuir.translateService.config;

import com.bsuir.translateService.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Олег Пятко on 16.05.2017.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AuthInterceptor createAuthInterceptor() {
        return new AuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(createAuthInterceptor()).excludePathPatterns("/login","/register");
    }