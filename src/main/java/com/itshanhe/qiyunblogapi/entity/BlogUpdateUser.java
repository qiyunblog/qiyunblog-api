package com.itshanhe.qiyunblogapi.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUpdateUser {

    @ApiModelProperty("token颁发的用户id")
    @NotNull(message = "UUid不能为空")
    private Integer userID;

    @ApiModelProperty("用户密码")
    @NotEmpty(message = "密码不能为空")
    @Length(min = 6, max = 18, message = "密码要6-18位")
    private String userPassword;

    @ApiModelProperty("用户昵称")
    @NotEmpty(message = "昵称不能为空")
    private String userNickName;

    @ApiModelProperty("用户邮箱")
    @NotEmpty(message = "邮箱不能为空")
    private String userEmail;
}
