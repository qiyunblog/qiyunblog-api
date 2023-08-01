package com.itshanhe.qiyunblogapi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 用户token
 */
@Data
public class BlogUserToken {

    @ApiModelProperty("token 用户id")
    private Long tokenUserId;
    @ApiModelProperty("token值(32位字符串)")
    private String token;
    @ApiModelProperty("token 修改时间")
    private Date tokenUpdateTime;
    @ApiModelProperty("token 过期时间")
    private Date tokenExpireTime;
}
