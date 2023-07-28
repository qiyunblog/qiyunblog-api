package com.itshanhe.qiyunblogapi.service;

/**
 * 文章相关接口
 */
public interface ContentService {
    /**
     * 添加文章
     * @param htmlBody
     * @param id
     * @return
     */
    int addArticle(String htmlBody,String id);
    
    /**
     * 删除文章
     * @param id
     * @return
     */
    int deleteArticle(String id);
}
