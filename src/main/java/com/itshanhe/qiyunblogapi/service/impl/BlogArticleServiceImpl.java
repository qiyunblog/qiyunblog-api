package com.itshanhe.qiyunblogapi.service.impl;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleMapper;
import com.itshanhe.qiyunblogapi.service.BlogArticleService;

public class BlogArticleServiceImpl implements BlogArticleService {

    private BlogArticleMapper blogArticleMapper;

    @Override
    public int insertArticle(BlogArticle blogArticle) {
        return blogArticleMapper.insertArticle(blogArticle);
    }

    @Override
    public int updateArticleLikeNum(Integer id, Integer likeNum) {
        return blogArticleMapper.updateArticleLikeNum(id,likeNum);
    }


    @Override
    public int updateArticleIntroduction(Integer id, String introduction) {
        return blogArticleMapper.updateArticleIntroduction(id,introduction);
    }
}
