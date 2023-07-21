package com.itshanhe.qiyunblogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUser {
//    用户ID
    private Integer userId;
//    用户账号
    private String userUsername;
//    用户密码
    private String userPassword;
//    用户昵称
    private String userNickName;
//    是否锁定 0 未锁定 1锁定
    private Integer userLocked;
}
