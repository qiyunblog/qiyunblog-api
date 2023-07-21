package com.itshanhe.qiyunblogapi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itshanhe.qiyunblogapi.mapper")
public class QiyunblogApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(QiyunblogApiApplication.class, args);
    }
    
}
