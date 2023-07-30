package com.itshanhe.qiyunblogapi.service.impl;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleMapper;
import com.itshanhe.qiyunblogapi.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogArticleServiceImpl implements BlogArticleService {

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    /**
     * 添加新的文章
     *
     * @param blogArticle 用户和文章属性
     * @return
     */
    @Override
    public Boolean insertArticle(BlogArticle blogArticle) {
        return blogArticleMapper.insertArticle(blogArticle) > 0;
    }

    /**
     * 修改点赞量
     *
     * @param id      文章id
     * @param likeNum 点赞量
     * @return
     */
    @Override
    public Boolean updateArticleLikeNum(Integer id, Integer likeNum) {
        return blogArticleMapper.updateArticleLikeNum(id, likeNum) > 0;
    }

    /**
     * 修改简介
     *
     * @param id           文章id
     * @param introduction 简介
     * @return
     */
    @Override
    public Boolean updateArticleIntroduction(Integer id, String introduction) {
        return blogArticleMapper.updateArticleIntroduction(id, introduction) > 0;
    }


}
