package com.itshanhe.qiyunblogapi;

import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import com.itshanhe.qiyunblogapi.mapper.BolgContentMapper;
import com.itshanhe.qiyunblogapi.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QiyunblogApiApplicationTests {
//    @Autowired
//    private BolgContentMapper bolgContentMapper;
    @Test
    public void a() {
        System.out.println(RandomUtil.generateValidateCode());
    }

//    @Test
//    public void testSql(){
//
//        int i = bolgContentMapper.insertBlog(new BlogArticleContent(111, 222, "测试", "好", null, null));
//        System.out.println("改变了"+i);
//    }



//    public void b(){
//        System.out.println();
//    }
    
}
