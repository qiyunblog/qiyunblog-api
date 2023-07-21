package com.itshanhe.qiyunblogapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserAnd {
    //    用户ID
    private int andUserId;
    //    注册时间
    private Date andUserDate;
    //    修改时间
    private Date andUserUpdateDate;
    //    权限 默认0 无权限
    private int andUserAdmin;
}
