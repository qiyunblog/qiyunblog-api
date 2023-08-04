package com.itshanhe.qiyunblogapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("博客文章表")
public class BlogArticle {

    @ApiModelProperty("用户id")
    private Integer articleUserId;
    @ApiModelProperty("文章ID")
    private Integer articleBlogId;
    @ApiModelProperty("文章图片")
    private Integer articleBlogImageId;
    @ApiModelProperty("文章简介")
    private String articleBlogIdContent;
    @ApiModelProperty("文章评论")
    private Integer articleNum;
    @ApiModelProperty("文章发布时间")
    private LocalDateTime articleBlogDate;
    @ApiModelProperty("文章内部属性")
    private BlogArticleContent blogArticleContent;
}
