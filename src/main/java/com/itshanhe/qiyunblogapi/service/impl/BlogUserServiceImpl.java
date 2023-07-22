package com.itshanhe.qiyunblogapi.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.itshanhe.qiyunblogapi.entity.BlogUser;
import com.itshanhe.qiyunblogapi.entity.Result;
import com.itshanhe.qiyunblogapi.mapper.BlogUserMapper;
import com.itshanhe.qiyunblogapi.service.BlogUserService;
import com.itshanhe.qiyunblogapi.util.JwtUtil;
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
    
    /**
     * 用户登陆
     * @param username 用户账号
     * @param password 用户密码
     * @return BlogUser 实体类
     */
    @Override
    public BlogUser userLogin(String username, String password) {
        BlogUser selectUserData =  userMapper.selectUserData(username);
        //        判断是否有账号
        if (selectUserData == null) {
            log.info("未查询到有账号");
            return null;
        }
//        如果账号正确,那就开始比对加密后的密码
        if (!password.equals(selectUserData.getUserPassword())) {
            log.info("密码错误,账号为:{}",selectUserData.getUserUsername());
            log.info("查询到的密码是:{},提交的密码是:{}",selectUserData.getUserPassword(),password);
            return null;
        }
        log.info("成功{}",selectUserData);
//        都比对成功就返回成功
        return selectUserData;
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
    
    /**
     * 设置用户token信息
     * @param userId 用户id
     * @param jwtToken token信息
     */
    @Override
    public void userSetToken(Integer userId, String jwtToken) {
        String token = userMapper.userSelectToken(userId);
//        判断token是不是已经存在
        if (token !=null) {
//            修改Token值
            userMapper.userUpdateToken(userId,jwtToken);
            return;
        }
        userMapper.userSetToken(userId,jwtToken);
    }
    
    /**
     * 更改用户信息
     * @param userID 用户ID
     * @param token 令牌
     * @return 1成功 -1失败
     */
    @Override
    public int userTokenStatus(Integer userID, String token) {
        String userToken = userMapper.userSelectToken(userID);
        if (token != null) {
//            判断token是否存在,然后再判断是否过期了
            //5.解析token，如果解析失败，返回错误结果（未登录）。
            try {
                JwtUtil.parseJWT(token);
//                log.info("{}",JwtUtil.parseJWT(token));
            } catch (Exception e) {//jwt解析失败
                e.printStackTrace();
                log.info("解析令牌失败, 返回未登录错误信息");
                return -1;
            }
//            存在
            return 1;
        } else {
//            不存在token就返回-1
            return -1;
        }
    }
}
