package com.itshanhe.qiyunblogapi.mapper;

import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface BlogArticleContentMapper {
    /**
     * 添加文章
     * @param blogArticleContent 文章属性
     * @return 1 成功 0 失败
     */
    @Insert("INSERT INTO qiyun_blog_article_content values (#{id},DEFAULT,#{param2.contentArticleBlogName},#{param2.contentArticleBlogBoy},#{param2.contentArticleBlogKeyword},DEFAULT)")
    int insertBlog(Integer id, BlogArticleContent blogArticleContent);//contentArticleBlogArticleId

    /**
     * 删除文章
     * @param id 文章id
     * @return 1 成功 0 失败
     */
    @Delete("DELETE FROM qiyun_blog_article_content WHERE content_article_blog_id=#{id}")
    int deleteBlog(Integer id);

    /**
     * 修改文章属性
     * @param blogArticleContent 文章属性
     * @return 1 成功 0 失败
     */

    int updateBlog(Integer id,@Param("blogArticleContent") BlogArticleContent blogArticleContent);

    /**
     * 根据文章id查询文章属性
     * @param id 文章id
     * @return 文章属性
     */
    @Select("SELECT * FROM qiyun_blog_article_content WHERE content_article_blog_id=#{id}")
    BlogArticleContent selectBlogArticleByArticleBlogId(Integer id);


}
