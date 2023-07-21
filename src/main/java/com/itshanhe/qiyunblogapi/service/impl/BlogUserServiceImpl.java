package com.itshanhe.qiyunblogapi.service.impl;

import com.itshanhe.qiyunblogapi.entity.BlogUser;
import com.itshanhe.qiyunblogapi.mapper.BlogUserMapper;
import com.itshanhe.qiyunblogapi.service.BlogUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BlogUserServiceImpl implements BlogUserService {
    
    @Autowired
    private BlogUserMapper userMapper;
    
    /**
     * 用户注册
     * @param username 用户账号
     * @param password 用户密码
     * @param nickname 用户昵称
     * @return
     * -1 账号相同
     * 0 服务端未知错误
     * 1 注册成功
     */
    @Override
    public int userRegister(String username, String password, String nickname,String email) {
        BlogUser selectUserDataName = userMapper.selectUserDataName(username);
        log.info("user:{}",selectUserDataName);
//        判断是否有相同账号
        if (selectUserDataName != null) {
            log.info("查询到有相同账号:{}",selectUserDataName.getUserUsername());
            return -1;
        }
//        执行注册
        int registerUser = userMapper.registerUser(username,password,nickname,email);
        if (registerUser > 0) {
//            成功执行 返回正确
            return 1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String userLogin(String username, String password) {
        return null;
    }
    
    @Override
    public Boolean userUpdateInfo(BlogUser blogUser) {
        return null;
    }
    
    /**
     * 根据用户账号获取用户ID
     * @param userUsername 用户账号
     * @return id
     */
    @Override
    public String userGetId(String userUsername) {
        String id = userMapper.userGetId(userUsername);
        return id;
    }
    
    /**
     * 根据用户名删除用户
     * @param userUsername 用户名
     * @return 1 删除成功 -1 删除失败
     */
    @Override
    public int userDeleteName(String userUsername) {
        int userDeleteResult = userMapper.userDeleteName(userUsername);
        if (userDeleteResult > 0) {
            return 1;
        } else {
            return -1;
        }
    }
    
    /**
     * 查看用户是否锁定
     * @param id 用户id
     * @return 1 锁定 0没锁定
     */
    @Override
    public int userLocked(String id) {
        int locked = userMapper.userGetLocked(id);
        return locked;
    }
    
    @Override
    public int setLocked(String id, int setLock) {
        int lock = userMapper.setLocked(id,setLock);
        return 0;
    }
}
