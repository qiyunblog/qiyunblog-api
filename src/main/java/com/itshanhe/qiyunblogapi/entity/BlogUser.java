package com.itshanhe.qiyunblogapi.entity;

import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty("用户ID")
    private Integer userId;
    @ApiModelProperty("用户账号")
    private String userUsername;
    @ApiModelProperty("用户密码")
    private String userPassword;
    @ApiModelProperty("用户昵称")
    private String userNickName;
    @ApiModelProperty("是否锁定 0 未锁定 1锁定")
    private Integer userLocked;
}
