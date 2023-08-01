package com.itshanhe.qiyunblogapi.mapper;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BlogArticleMapper {


    /**
     * 添加新的文章
     *
     * @param blogArticle 用户和文章连接属性
     * @return
     * TODO 文章ID默认值需要修改
     */
    @Insert("INSERT INTO qiyun_blog_article VALUES (#{articleUserId},#{articleBlogId},DEFAULT,#{articleBlogIdContent},#{articleBlogDate},DEFAULT)")
    int insertArticle(BlogArticle blogArticle);


    /**
     * 查询所有文章id
     * @param id 用户id
     * @return
     */
    @Select("SELECT article_blog_id FROM qiyun_blog_article WHERE article_user_id=#{id}")
    List<Integer> selectAllArticleIdByUserId(Integer id);

    /**
     * 删除文章
     * @param id 文章id
     * @return
     */
    @Delete("DELETE FROM qiyun_blog_article WHERE article_blog_id=#{id}")
    int deleteArticleById(Integer id);

    /**
     * 修改文章
     * @param blogArticle 文章属性
     * @return
     */
    @Update("UPDATE qiyun_blog_article SET article_blog_image_id=#{articleBlogImageId}," +
            "article_blog_id_content=#{articleBlogIdContent},article_num=#{articleNum} WHERE article_blog_id=#{articleBlogId}")
    int updateArticle(BlogArticle blogArticle);
}
