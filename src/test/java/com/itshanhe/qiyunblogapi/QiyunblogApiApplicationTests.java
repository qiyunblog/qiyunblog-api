package com.itshanhe.qiyunblogapi;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleMapper;
import com.itshanhe.qiyunblogapi.service.BlogArticleContentService;
import com.itshanhe.qiyunblogapi.service.BlogArticleService;
import com.itshanhe.qiyunblogapi.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QiyunblogApiApplicationTests {
    @Autowired
    private BlogArticleService blogArticleService;

    @Autowired
    private BlogArticleContentService blogArticleContentService;

    @Test
    public void a() {
        System.out.println(RandomUtil.generateValidateCode());
    }

    @Test
    public void testSqlInsertArticle(){
        BlogArticle blogArticle = new BlogArticle(null,null,null,"1",null,null,null);
        int i = blogArticleService.insertArticle(blogArticle);
        System.out.println("改变了"+i);
    }
    @Test
    public void testSqlUpdateArticleLikeNum(){
        int i = blogArticleService.updateArticleLikeNum(1, 1);
        System.out.println("改变了"+i);
    }
    @Test
    public void testSql(){
        int i = blogArticleService.updateArticleIntroduction(1,"我是简");
        System.out.println("改变了"+i);
    }

    @Test
    public void testInsertBlog(){
        BlogArticleContent blogArticleContent = new BlogArticleContent(null, "我是标题", "我是内容", "我是关键字", null);

        int i = blogArticleContentService.HideArticle(100201,-1);
        System.out.println("测试:"+i);
    }


    @Test
    public void testSelectBlogArticleId(){
        List<BlogArticleContent> blogArticleContents = blogArticleContentService.selectAllArticleById(1002);
        System.out.println("测试:"+blogArticleContents);
    }
    @Test
    public void te(){
        BlogArticleContent blogArticleContent = new BlogArticleContent(1,"我是文章标题","我是文章内容","我是关键字",0);
        int i = blogArticleContentService.updateBlog(100201, blogArticleContent);
        System.out.println("测试:"+i);
    }


//    public void b(){
//        System.out.println();
//    }
    
}
