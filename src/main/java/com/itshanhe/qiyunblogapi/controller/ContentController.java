package com.itshanhe.qiyunblogapi.controller;

import com.itshanhe.qiyunblogapi.entity.BlogArticle;
import com.itshanhe.qiyunblogapi.entity.Result;
import com.itshanhe.qiyunblogapi.service.BlogArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 博客文章 （web）
 */
@Api("博客文章")
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
    @ApiOperation("新增博客")
    @PostMapping
    public Result save(@RequestBody BlogArticle blogArticle){

        if (!blogArticleService.insertArticle(blogArticle)){
            return Result.error("新增博客失败");
        }

        return Result.success("新增博客成功");
    }

    /**
     * 删除文章
     * @param id 文章id
     * @return
     */
    @ApiOperation("删除文章")
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
    @ApiOperation("修改文章")
    @PutMapping
    public Result update(@RequestBody BlogArticle blogArticle){

        try {
            blogArticleService.updateBlog(blogArticle);
        } catch (Exception e) {
            return Result.error("修改失败");
        }
        return Result.success("修改成功");
    }

    /**
     * 根据文章id查文章属性
     * @param id 文章id
     * @return
     */
    @ApiOperation("查询文章")
    @GetMapping("{id}")
    public Result get(@PathVariable Integer id){
        return Result.success(blogArticleService.selectBlogArticleByArticleBlogId(id));
    }

    /**
     * 根据用户id查所有文章
     * @param id 用户id
     * @return
     */
    @ApiOperation("查询所有文章")
    @GetMapping("getAll/{id}")
    public Result getAll(@PathVariable Integer id){
        return Result.success(blogArticleService.selectAllByUserId(id));
    }


}
