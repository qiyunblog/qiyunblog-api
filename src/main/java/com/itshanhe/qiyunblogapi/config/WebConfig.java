package com.itshanhe.qiyunblogapi.config;

import com.itshanhe.qiyunblogapi.interceptor.WebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置类 MVC配置
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private WebInterceptor interceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        需要拦截的内容以及不需要拦截的内容
        registry.addInterceptor(interceptor).addPathPatterns("/user/")
                .excludePathPatterns("/user/login","/user/register","/user/emailVerify","/user/updateUser");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/home/**").addResourceLocations("classpath:/web/");
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        指定控制器
        registry.addViewController("/").setViewName("/home/index.html");
    }
}
