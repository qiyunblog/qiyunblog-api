package com.itshanhe.qiyunblogapi;

import com.itshanhe.qiyunblogapi.controller.ContentController;
import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import com.itshanhe.qiyunblogapi.entity.Result;
import com.itshanhe.qiyunblogapi.service.BlogArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QiyunblogApiApplicationTests {

    @Autowired
    BlogArticleService blogArticleService;
    @Autowired
    ContentController contentController;
    @Test
    public void testInsert(){
        BlogArticleContent blogArticleContent = new BlogArticleContent(100201,"我是文章标题","我是文章内容","我是关键字",0);
        BlogArticle blogArticle = new BlogArticle(1002,100203,1,"我是文章简介",0,null,blogArticleContent);
        blogArticleService.insertArticle(blogArticle);
    }
    @Test
    public void delete(){
        Result result = contentController.get(100201);
    }


//    public void b(){
//        System.out.println();
//    }
    
}
