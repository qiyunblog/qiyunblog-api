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
    private String articleUserId;
//    文章ID
    private String articleBlogId;
//    文章评论
    private Integer articleNum;
//    文章发布时间
    private Date articleBlogDate;
}
