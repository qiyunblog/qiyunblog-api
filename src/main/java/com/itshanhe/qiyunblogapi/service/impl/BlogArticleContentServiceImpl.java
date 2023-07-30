package com.itshanhe.qiyunblogapi.service.impl;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleContentMapper;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleMapper;
import com.itshanhe.qiyunblogapi.service.BlogArticleContentService;
import com.itshanhe.qiyunblogapi.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogArticleContentServiceImpl implements BlogArticleContentService {
    @Autowired
    private BlogArticleContentMapper blogArticleContentMapper;
    @Autowired
    private BlogArticleMapper blogArticleMapper;
    /**
     * 添加文章
     * @param blogArticleContent 文章属性
     * @return 1 成功 0 失败
     */
    @Override
    public int insertBlog(Integer id,BlogArticleContent blogArticleContent) {
        return blogArticleContentMapper.insertBlog(id, blogArticleContent);
    }
    /**
     * 删除文章
     * @param id 文章id
     * @return 1 成功 0 失败
     */
    @Override
    public int deleteBlog(Integer id) {
        return blogArticleContentMapper.deleteBlog(id);
    }
    /**
     * 修改文章属性
     * @param blogArticleContent 文章属性
     * @return 1 成功 0 失败
     */
    @Override
    public int updateBlog(Integer id,BlogArticleContent blogArticleContent) {
        return blogArticleContentMapper.updateBlog(id,blogArticleContent);
    }
    /**
     * 根据文章id查询文章属性
     * @param id 文章id
     * @return 文章属性
     */
    @Override
    public BlogArticleContent selectBlogArticleByArticleBlogId(Integer id) {
        return blogArticleContentMapper.selectBlogArticleByArticleBlogId(id);
    }

    /**
     * 调整文章精选(-1 :隐藏文章  0 :不精选)
     * @param id 文章id
     * @return 1 成功 0 失败
     */
    @Override
    public int HideArticle(Integer id, Integer recommend) {

        return blogArticleContentMapper.HideArticle(id,recommend);
    }

    /**
     * 查询所有文章
     * @param id 用户id
     * @return
     */
    @Override
    public List<BlogArticleContent> selectAllArticleById(Integer id) {
        //根据用户id查询所有文章id
        List<Integer> integers = blogArticleMapper.selectAllArticleIdByUserId(id);
        //使用文章id查询所有文章
        List<BlogArticleContent> blogArticleContents=new ArrayList<>();
        for (Integer articleId : integers) {
            blogArticleContents.add(blogArticleContentMapper.selectBlogArticleByArticleBlogId(articleId));
        }
        //返回存放所有关于用户id的文章
        return blogArticleContents;
    }


}
