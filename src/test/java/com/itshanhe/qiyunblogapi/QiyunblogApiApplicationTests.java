package com.itshanhe.qiyunblogapi;

import com.itshanhe.qiyunblogapi.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


class QiyunblogApiApplicationTests {

    @Test
    public void a() {
        System.out.println(RandomUtil.generateValidateCode());
    }
    
//    public void b(){
//        System.out.println();
//    }
    
}
