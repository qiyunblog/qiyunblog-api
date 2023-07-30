package com.itshanhe.qiyunblogapi.service;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import org.apache.ibatis.annotations.Insert;

import java.util.Date;
import java.util.List;

public interface BlogArticleService {
    /**
     * 添加新的文章
     * @param blogArticle 用户和文章属性
     * @return
     */
    int insertArticle(BlogArticle blogArticle);

    /**
     * 修改点赞量
     * @param id 文章id
     * @param likeNum 点赞量
     * @return
     */
    int updateArticleLikeNum(Integer id,Integer likeNum);

    /**
     * 修改简介
     * @param id 文章id
     * @param introduction 简介
     * @return
     */
    int updateArticleIntroduction(Integer id,String introduction);



}
