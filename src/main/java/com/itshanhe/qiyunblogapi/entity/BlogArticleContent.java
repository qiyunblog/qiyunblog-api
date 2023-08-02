package com.itshanhe.qiyunblogapi.entity;

import com.itshanhe.qiyunblogapi.Constant.BlogConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogArticleContent {

    @ApiModelProperty("文章分类ID")
    private Integer contentArticleBlogArticleId;
    @ApiModelProperty("文章标题")
    private String contentArticleBlogName;
    @ApiModelProperty("文章内容")
    private String contentArticleBlogBoy;
    @ApiModelProperty("文章关键词")
    private String contentArticleBlogKeyword;
    @ApiModelProperty("文章精选")
    private Integer contentArticleRecommend;

    public BlogArticleContent(Integer contentArticleBlogArticleId, String contentArticleBlogName, String contentArticleBlogBoy, String contentArticleBlogKeyword) {
        this.contentArticleBlogArticleId = contentArticleBlogArticleId;
        this.contentArticleBlogName = contentArticleBlogName;
        this.contentArticleBlogBoy = contentArticleBlogBoy;
        this.contentArticleBlogKeyword = contentArticleBlogKeyword;
        this.contentArticleRecommend = BlogConstant.DEFAULT;
    }
}
