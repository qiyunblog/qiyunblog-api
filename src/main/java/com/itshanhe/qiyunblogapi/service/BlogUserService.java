package com.itshanhe.qiyunblogapi.service;

import com.itshanhe.qiyunblogapi.entity.BlogUser;

import java.util.Map;

/**
 * 用户相关接口
 */
public interface BlogUserService {
    /**
     * 用户注册
     * @param username 用户账号
     * @param password 用户密码
     * @param nickname 用户昵称
     * @return
     */
    int userRegister(String username,String password,String nickname,String email);
    
    /**
     * 用户登陆
     * @param username 用户账号
     * @param password 用户密码
     * @return
     */
    BlogUser userLogin(String username,String password);
    
    /**
     * 用户信息修改
     * @param blogUser
     * @return
     */
    Boolean userUpdateInfo(BlogUser blogUser);
    
    /**
     * 根据账号获取用户ID
     * @param userUsername 用户账号
     * @return id
     */
    String userGetId(String userUsername);
    
    /**
     * 根据用户名删除用户
     * @param userUsername 用户名
     * @return 1 删除成功 -1 删除失败
     */
    int userDeleteName(String userUsername);
    
    /**
     * 查看用户是否锁定
     * @param id 用户id
     * @return 1 锁定 0 没锁定
     */
    int userLocked(String id);
    
    /**
     * 更改用户锁定状态
     * @param id id
     * @param setLock 1为锁定 0为解锁
     * @return
     */
    int setLocked(String id,int setLock);
    
    /**
     * 设置用户token信息
     * @param userId 用户id
     * @param jwtToken token信息
     */
    void userSetToken(Integer userId, String jwtToken);
}
