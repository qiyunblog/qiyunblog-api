package com.itshanhe.qiyunblogapi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserAnd {

    @ApiModelProperty("用户ID")
    private int andUserId;
    @ApiModelProperty("注册时间")
    private Date andUserDate;
    @ApiModelProperty("修改时间")
    private Date andUserUpdateDate;
    @ApiModelProperty("权限 默认0 无权限")
    private int andUserAdmin;
}
