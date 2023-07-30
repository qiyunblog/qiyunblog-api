package com.itshanhe.qiyunblogapi.mapper;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import org.apache.ibatis.annotations.Insert;

public interface BlogArticleMapper {
    //添加新的文章
    int insertArticle(BlogArticle blogArticle);
    //通过文章id进行修改点赞量
    int updateArticleLikeNum(Integer id,Integer likeNum);
    //通过文章id进行修改简介
    int updateArticleIntroduction(Integer id,String introduction);

}
