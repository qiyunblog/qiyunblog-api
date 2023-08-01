package com.itshanhe.qiyunblogapi.service;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface BlogArticleService {

    /**
     * 添加新的文章
     *
     * @param blogArticle 用户和文章属性
     * @return
     */
    Boolean insertArticle(BlogArticle blogArticle);

    /**
     * 删除文章
     *
     * @param id 文章id
     * @return
     */
    Boolean deleteBlog(Integer id);

    /**
     * 修改文章属性
     *
     * @param blogArticle 文章属性
     * @return
     */
    Boolean updateBlog(BlogArticle blogArticle);

    /**
     * 根据文章id查询文章属性
     *
     * @param id 文章id
     * @return 文章属性
     */
    BlogArticleContent selectBlogArticleByArticleBlogId(Integer id);


    /**
     * 根据用户id查询所有文章
     *
     * @param id 用户id
     * @return
     */
    List<BlogArticleContent> selectAllByUserId(Integer id);


//
//
//    /**
//     * 调整文章精选(-1 :隐藏文章  0 :不精选)
//     *
//     * @param id 文章id
//     * @return
//     */
//    @Update("UPDATE qiyun_blog_article_content SET content_article_recommend = #{recommend}")
//    Boolean HideArticle(Integer id, Integer recommend);
//

//    /**
//     * 修改简介
//     *
//     * @param id           文章id
//     * @param introduction 简介
//     * @return
//     */
//    Boolean updateArticleIntroduction(Integer id, String introduction);


}
