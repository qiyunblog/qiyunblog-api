package com.itshanhe.qiyunblogapi.util;



import java.util.Random;


public class RandomUtil {
    
    public static Integer generateValidateCode(){
        Integer code =null;
        code = new Random().nextInt(999999);//生成随机数，最大为999999
        if(code < 100000){
            code = code + 100000;//保证随机数为6位数字
        }
        return code;
    }
    
}
