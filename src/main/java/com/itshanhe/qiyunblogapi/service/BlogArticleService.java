package com.itshanhe.qiyunblogapi.service;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import org.apache.ibatis.annotations.Insert;

import java.util.Date;

public interface BlogArticleService {

    /**
     * 添加新的文章
     * @param blogArticle 文章属性
     * @return 1 成功 0 失败
     */
    @Insert("INSERT INTO qiyun_blog_article VALUES (#{articleUserId},#{articleBlogId},#{articleNum},#{articleBlogDate})")
    int insertArticle(BlogArticle blogArticle);


    /**
     * 更新点赞量
     * @param id 文章id
     * @return 1 成功 0 失败
     */
    int updateArticleBolgLikeNum(Integer id);



    /**
     * 修改文章图片
     * @param id 文章id
     * @param imgPath 图片路径
     * @return 1 成功 0 失败
     */
    int updateArticleImg(Integer id,String imgPath);

    /**
     * 修改文章简介
     * @param id 文章id
     * @param introduction 文章简介
     * @return 1 成功 0 失败
     */
    int updateArticleIntroduction(Integer id,String  introduction);
}
