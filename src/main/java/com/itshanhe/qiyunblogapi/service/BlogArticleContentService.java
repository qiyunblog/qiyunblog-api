package com.itshanhe.qiyunblogapi.service;

import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BlogArticleContentService {
    /**
     * 添加文章
     * @param blogArticleContent 文章属性
     * @return 1 成功 0 失败
     */

    int insertBlog(Integer id,BlogArticleContent blogArticleContent);

    /**
     * 删除文章
     * @param id 文章id
     * @return 1 成功 0 失败
     */
    int deleteBlog(Integer id);

    /**
     * 修改文章属性
     * @param blogArticleContent 文章属性
     * @return 1 成功 0 失败
     */
    int updateBlog(Integer id,BlogArticleContent blogArticleContent);

    /**
     * 根据文章id查询文章属性
     * @param id 文章id
     * @return 文章属性
     */
    BlogArticleContent selectBlogArticleByArticleBlogId(Integer id);


    /**
     * 调整文章精选(-1 :隐藏文章  0 :不精选)
     * @param id 文章id
     * @return 1 成功 0 失败
     */
    @Update("UPDATE qiyun_blog_article_content SET content_article_recommend = #{recommend}")
    int HideArticle(Integer id,Integer recommend);

    /**
     * 根据用户id查询所有文章中
     * @param id 用户id
     * @return
     */
    List<BlogArticleContent> selectAllArticleById(Integer id);

}
