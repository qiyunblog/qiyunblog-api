package com.itshanhe.qiyunblogapi.mapper;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import org.apache.ibatis.annotations.Insert;

public interface BlogArticeMapper {
    /**
     * 修改文章上传日期
     * @param blogArticle 文章属性
     * @return
     */
    @Insert("INSERT INTO qiyun_blog_article VALUES (#{articleUserId},#{articleBlogId},#{articleNum},#{articleBlogDate})")
    int updateArticleBlogDate(BlogArticle blogArticle);

    /**
     * 修改文章点赞量
     * @param blogArticle 文章属性
     * @return
     */
    int updateArticleBolgLikeNum(BlogArticle blogArticle);

    /**
     * 添加新的文章
     * @param blogArticle
     * @return
     */
    int insertArticleBolg(BlogArticle blogArticle);
}
