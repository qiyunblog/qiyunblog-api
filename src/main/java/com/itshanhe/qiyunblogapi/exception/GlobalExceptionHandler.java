package com.itshanhe.qiyunblogapi.exception;

import com.itshanhe.qiyunblogapi.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.mail.MessagingException;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
//    @ExceptionHandler(Exception.class)//捕获所有异常
//    public Result ex(Exception ex){
//        ex.printStackTrace();
//        return Result.error("对不起,操作失败,请联系管理员");
//    }
//    @ExceptionHandler(MessagingException.class)//捕获所有异常
//    public Result ex(MessagingException ex){
//        ex.printStackTrace();
//        return Result.error("邮件发送失败,请重新注册");
//    }
    
}