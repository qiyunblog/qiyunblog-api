package com.itshanhe.qiyunblogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {
    private Integer code;//响应码
    private String msg;  //响应信息 描述字符串
    private Object data; //返回的数据
    private static final int RESULT_CODE_TRUE = 200; //成功的状态码
    private static final int RESULT_CODE_ERROR = 404; // 失败的状态码
    private static final int RESULT_CODE_NULL = 405; // 不存在的状态码
    
    //执行成功响应
    public static Result success(){
        return new Result(RESULT_CODE_TRUE,"success",null);
    }
    //返回值的成功响应
    public static Result success(Object data){
        return new Result(RESULT_CODE_TRUE,"success",data);
    }
//    直接返回 信息
    public static Result success(String msg){
        return new Result(RESULT_CODE_TRUE,msg,null);
    }
//    执行成功并需要返回值和描述
    public static Result success(String msg,Object data){
        return new Result(RESULT_CODE_TRUE,msg,data);
    }
    //失败响应
    public static Result error(String msg){
        return new Result(RESULT_CODE_ERROR,msg,null);
    }
}