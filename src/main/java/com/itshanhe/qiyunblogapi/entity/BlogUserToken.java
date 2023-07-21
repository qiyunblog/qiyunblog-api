package com.itshanhe.qiyunblogapi.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户token
 */
@Data
public class BlogUserToken {
//    token 用户id
    private Long tokenUserId;
//    token值(32位字符串)
    private String token;
//    token 修改时间
    private Date tokenUpdateTime;
//    token 过期时间
    private Date tokenExpireTime;
}
