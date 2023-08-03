package com.itshanhe.qiyunblogapi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.itshanhe.qiyunblogapi.mapper")
@EnableTransactionManagement
public class QiyunblogApiApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(QiyunblogApiApplication.class, args);
    }
    
}
