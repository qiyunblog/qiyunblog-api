package com.itshanhe.qiyunblogapi.service.impl;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.BlogArticleContent;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleContentMapper;
import com.itshanhe.qiyunblogapi.mapper.BlogArticleMapper;
import com.itshanhe.qiyunblogapi.service.BlogArticleService;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogArticleServiceImpl implements BlogArticleService {

    @Autowired
    private BlogArticleContentMapper blogArticleContentMapper;
    @Autowired
    private BlogArticleMapper blogArticleMapper;

    /**
     * 添加博客文章
     *
     * @param blogArticle 文章属性
     * @return
     */
    @Override
    public Boolean insertArticle(BlogArticle blogArticle) {
        //插入文章表
        blogArticleMapper.insertArticle(blogArticle);

        //插入文章内容信息
        BlogArticleContent blogArticleContent = new BlogArticleContent();
        BeanUtils.copyProperties(blogArticle.getBlogArticleContent(), blogArticleContent);

        //获取文章id
        Integer BlogId = blogArticle.getArticleBlogId();

        return blogArticleContentMapper.insertBlog(BlogId, blogArticleContent) > 0;
    }

    /**
     * 删除文章
     *
     * @param id 文章id
     * @return
     */
    @Override
    public Boolean deleteBlog(Integer id) {
        int i = blogArticleContentMapper.deleteBlog(id);

        if (i == 1) {
            //文章删除成功
            return blogArticleMapper.deleteArticleById(id) > 1;
        }

        throw new RuntimeException("删除文章失败");
    }

    /**
     * 修改文章属性
     *
     * @param blogArticle 文章属性
     * @return
     */
    @Override
    @Transactional
    public Boolean updateBlog(BlogArticle blogArticle) {
        //获取文章id
        Integer id = blogArticle.getArticleBlogId();

        //插入文章信息
        BlogArticleContent blogArticleContent = new BlogArticleContent();
        BeanUtils.copyProperties(blogArticle.getBlogArticleContent(), blogArticleContent);
        //修改文章属性
        int i = 0;

        i += blogArticleMapper.updateArticle(blogArticle);
        i += blogArticleContentMapper.updateBlog(id, blogArticleContent);

        if (i == 2) {
            return true;
        }
        throw new RuntimeException("修改失败");
    }

    /**
     * 根据文章id查询文章属性
     *
     * @param id 文章id
     * @return 文章属性
     */
    @Override
    public BlogArticleContent selectBlogArticleByArticleBlogId(Integer id) {
        return blogArticleContentMapper.selectBlogArticleByArticleBlogId(id);
    }

    /**
     * 查询所有文章
     *
     * @param id 用户id
     * @return
     */
    @Override
    public List<BlogArticleContent> selectAllByUserId(Integer id) {
        //根据用户id查询所有文章id
        List<Integer> integers = blogArticleMapper.selectAllArticleIdByUserId(id);
        //使用文章id查询所有文章
        List<BlogArticleContent> blogArticleContents = new ArrayList<>();
        for (Integer articleId : integers) {
            blogArticleContents.add(blogArticleContentMapper.selectBlogArticleByArticleBlogId(articleId));
        }
        //返回存放所有关于用户id的文章
        return blogArticleContents;
    }


///**
// //     * 调整文章精选(-1 :隐藏文章  0 :不精选)
// //     *
// //     * @param id 文章id
// //     * @return
// //     */
//    @Override
//    public Boolean HideArticle(Integer id, Integer recommend) {
//
//        return blogArticleContentMapper.HideArticle(id, recommend) > 0;
//    }

//    /**
//     * 修改简介
//     *
//     * @param id           文章id
//     * @param introduction 简介
//     * @return
//     */
//    @Override
//    public Boolean updateArticleIntroduction(Integer id, String introduction) {
//        return blogArticleMapper.updateArticleIntroduction(id, introduction) > 0;
//    }


}
