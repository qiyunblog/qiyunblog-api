package com.itshanhe.qiyunblogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogArticle {
//    用户id
    private Integer articleUserId;
//    文章ID
    private Integer articleBlogId;
//    文章图片
    private Integer articleBlogImageId;
//    文章简介
    private String articleBlogIdContent;
//    文章评论
    private Integer articleNum;
//    文章发布时间
    private Date articleBlogDate;
//    文章数据
    private BlogArticleContent blogArticleContent;
}
