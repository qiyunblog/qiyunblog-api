package com.itshanhe.qiyunblogapi.service.impl;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleContentMapper;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleMapper;
import com.itshanhe.qiyunblogapi.service.BlogArticleContentService;

import java.util.List;

public class BlogArticleContentServiceImpl implements BlogArticleContentService {
    private BlogArticleContentMapper blogArticleContentMapper;
    @Override
    public int insertBlog(Integer id,BlogArticleContent blogArticleContent) {
        return blogArticleContentMapper.insertBlog(id, blogArticleContent);
    }

    @Override
    public int deleteBlog(Integer id) {
        return blogArticleContentMapper.deleteBlog(id);
    }

    @Override
    public int updateBlog(Integer id,BlogArticleContent blogArticleContent) {
        return blogArticleContentMapper.updateBlog(id,blogArticleContent);
    }

    @Override
    public BlogArticleContent selectBlogArticleByArticleBlogId(Integer id) {
        return blogArticleContentMapper.selectBlogArticleByArticleBlogId(id);
    }

    @Override
    public List<BlogArticleContent> selectAllBlogArticleByUserId(Integer id) {
        return blogArticleContentMapper.selectAllBlogArticleByUserId(id);
    }

    @Override
    public int HideArticle(Integer id) {
        return blogArticleContentMapper.HideArticle(id);
    }
}
