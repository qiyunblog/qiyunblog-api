package com.itshanhe.qiyunblogapi.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Api("图片实体类")
public class BlogImg {
    @ApiModelProperty("图片id")
    private Integer articleBlogImgId;
    @ApiModelProperty("图片地址")
    private String articleBlogImgAddress;
    @ApiModelProperty("图片上传时间")
    private LocalDateTime articleBlogImgDate;
}
