package com.itshanhe.qiyunblogapi;

import com.itshanhe.qiyunblogapi.util.RandomUtil;
import org.junit.jupiter.api.Test;
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
//        int i = bolgContentMapper.insertBlog(new BlogArticleContent(111, 222, "����", "��", null, null));
//        System.out.println("�ı���"+i);
//    }



//    public void b(){
//        System.out.println();
//    }
    
}
