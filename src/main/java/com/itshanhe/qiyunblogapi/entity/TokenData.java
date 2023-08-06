package com.itshanhe.qiyunblogapi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TokenData {
    @ApiModelProperty("token 用户id")
    private int uuid;
    @ApiModelProperty("token 用户账号")
    private String name;
    @ApiModelProperty("token 用户名字")
    private String nickname;
}
