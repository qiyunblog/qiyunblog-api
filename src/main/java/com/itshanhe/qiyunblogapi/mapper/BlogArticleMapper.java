package com.itshanhe.qiyunblogapi.mapper;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BlogArticleMapper {


    /**
     * 添加新的文章
     *
     * @param blogArticle 用户和文章连接属性
     * @return
     */                                                              //文章ID默认值
    @Insert("INSERT INTO qiyun_blog_article VALUES (#{articleUserId},#{articleBlogId},DEFAULT,#{articleBlogIdContent},DEFAULT,DEFAULT)")
    int insertArticle(BlogArticle blogArticle);

    /**
     * 通过文章id进行修改点赞量
     *
     * @param id      文章id
     * @param likeNum 点赞量
     * @return
     */
    @Update("UPDATE qiyun_blog_article SET article_num= #{likeNum} WHERE article_blog_id= #{id}")
    int updateArticleLikeNum(Integer id, Integer likeNum);

    /**
     * 通过文章id进行修改简介
     *
     * @param id           文章id
     * @param introduction 简介
     * @return
     */
    @Update("UPDATE qiyun_blog_article SET article_blog_id_content=#{introduction} WHERE article_blog_id= #{id}")
    int updateArticleIntroduction(Integer id, String introduction);

    //根据用户id查询所有文章id
    @Select("SELECT article_blog_id FROM qiyun_blog_article WHERE article_user_id=#{id}")
    List<Integer> selectAllArticleIdByUserId(Integer id);
}
