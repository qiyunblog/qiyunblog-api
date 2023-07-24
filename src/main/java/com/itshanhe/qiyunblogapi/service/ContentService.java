package com.itshanhe.qiyunblogapi.service;

/**
 * 文章相关接口
 */
public interface ContentService {
    int addArticle(String htmlBody,String id);
    
    int deleteArticle(String id);
}
