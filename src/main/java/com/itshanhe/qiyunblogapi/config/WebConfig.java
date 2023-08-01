package com.itshanhe.qiyunblogapi.config;

import com.itshanhe.qiyunblogapi.interceptor.WebInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
    /**
     * 设置静态资源映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/home/**").addResourceLocations("classpath:/web/");
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        指定控制器
        registry.addViewController("/").setViewName("/home/index.html");
    }


    /**
     * 通过knife4j生成接口文档
     * @return
     */
    @Bean
    public Docket docket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("山河api接口文档")
                .version("1.0")
                .description("山河api接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itshanhe.qiyunblogapi.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }



}
