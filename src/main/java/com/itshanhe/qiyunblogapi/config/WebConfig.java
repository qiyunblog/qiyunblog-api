package com.itshanhe.qiyunblogapi.config;

import com.itshanhe.qiyunblogapi.interceptor.WebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private WebInterceptor interceptor;
    
    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/user/login").excludePathPatterns("/user/register");
    }
}
