package com.itshanhe.qiyunblogapi.service.impl;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import com.itshanhe.qiyunblogapi.mapper.BlogArticeMapper;
import com.itshanhe.qiyunblogapi.service.BlogArticleContentService;

import java.util.List;

public class BlogArticleContentServiceImpl implements BlogArticleContentService {
    private BlogArticeMapper blogArticeMapper;
    @Override
    public int insertBlog(BlogArticleContent blogArticleContent) {
        BlogArticle blogArticle = new BlogArticle();
        int i = blogArticeMapper.insertArticleBolg(blogArticle);

        return 0;
    }

    @Override
    public int deleteBlog(Integer id) {
        return 0;
    }

    @Override
    public int updateBlog(BlogArticleContent blogArticleContent) {
        return 0;
    }

    @Override
    public BlogArticleContent selectBlogArticleByArticleBlogId(Integer id) {
        return null;
    }

    @Override
    public List<BlogArticleContent> selectAllBlogArticleByUserId(Integer id) {
        return null;
    }

    @Override
    public int HideArticle(Integer id) {
        return 0;
    }
}
