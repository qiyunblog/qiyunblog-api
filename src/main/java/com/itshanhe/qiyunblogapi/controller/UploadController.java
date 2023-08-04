package com.itshanhe.qiyunblogapi.controller;

import com.itshanhe.qiyunblogapi.entity.Result;
import com.itshanhe.qiyunblogapi.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Api("文件上传控制器")
@RequestMapping("/Commons")
@Slf4j
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        String uuid = UUID.randomUUID().toString();
        //获取上传文件名
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));

        String fileName=uuid+substring;
        log.info(fileName);
        //获取文件上传路径
        String filePath="img/"+fileName;
        try {
            //上传文件到根目录下
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        uploadService.upload(filePath);
        //TODO 返回文件访问URL
        return Result.success();
    }
}
