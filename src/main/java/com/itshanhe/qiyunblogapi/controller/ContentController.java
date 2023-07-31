package com.itshanhe.qiyunblogapi.controller;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.Result;
import com.itshanhe.qiyunblogapi.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 博客文章 （web）
 */
@RestController
@RequestMapping("/article")
public class ContentController {
    @Autowired
    private BlogArticleService blogArticleService;

    /**
     * 新增文章
     * @param blogArticle 文章属性
     * @return
     */
    @PostMapping
    public Result insert(@RequestBody BlogArticle blogArticle){
        Boolean flag = blogArticleService.insertArticle(blogArticle);
        return Result.success("新增博客成功");
    }

    /**
     * 删除文章
     * @param id 文章id
     * @return
     */
    @DeleteMapping
    public Result delete(Integer id){
        blogArticleService.deleteBlog(id);
        return Result.success("删除成功");
    }

    /**
     * 修改文章
     * @param blogArticle 文章属性
     * @return
     */
    @PutMapping
    public Result update(@RequestBody BlogArticle blogArticle){
        blogArticleService.updateBlog(blogArticle);
        return Result.success("修改成功");
    }

    /**
     * 根据文章id查文章属性
     * @param id 文章id
     * @return
     */
    @GetMapping("get{id}")
    public Result get(@PathVariable Integer id){
        return Result.success(blogArticleService.selectBlogArticleByArticleBlogId(id));
    }

    /**
     * 根据用户id查所有文章
     * @param id 用户id
     * @return
     */
    @GetMapping("getAll{id}")
    public Result getAll(@PathVariable Integer id){
        return Result.success(blogArticleService.selectAllByUserId(id));
    }


}
