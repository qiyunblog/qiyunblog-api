package com.itshanhe.qiyunblogapi.entity;

import com.itshanhe.qiyunblogapi.Constant.BlogConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogArticleContent {
////    文章ID
//    private Integer contentArticleBlogId;
//    文章分类ID
    private Integer contentArticleBlogArticleId;
//    文章标题
    private String contentArticleBlogName;
//    文章内容
    private String contentArticleBlogBoy;
//    文章关键词
    private String contentArticleBlogKeyword;
//    文章精选
    private Integer contentArticleRecommend;

    public BlogArticleContent(Integer contentArticleBlogArticleId, String contentArticleBlogName, String contentArticleBlogBoy, String contentArticleBlogKeyword) {
        this.contentArticleBlogArticleId = contentArticleBlogArticleId;
        this.contentArticleBlogName = contentArticleBlogName;
        this.contentArticleBlogBoy = contentArticleBlogBoy;
        this.contentArticleBlogKeyword = contentArticleBlogKeyword;
        this.contentArticleRecommend= BlogConstant.DEFAULT;
    }
}
