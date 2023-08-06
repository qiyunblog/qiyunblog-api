package com.itshanhe.qiyunblogapi.controller;

import com.itshanhe.qiyunblogapi.entity.BlogUpdateUser;
import com.itshanhe.qiyunblogapi.entity.BlogUser;
import com.itshanhe.qiyunblogapi.entity.Result;
import com.itshanhe.qiyunblogapi.entity.TokenData;
import com.itshanhe.qiyunblogapi.param.BlogLoginParam;
import com.itshanhe.qiyunblogapi.param.BlogRegisterParam;
import com.itshanhe.qiyunblogapi.param.BlogUpdateParam;
import com.itshanhe.qiyunblogapi.service.BlogUserService;
import com.itshanhe.qiyunblogapi.service.MailService;
import com.itshanhe.qiyunblogapi.util.DomainUtil;
import com.itshanhe.qiyunblogapi.util.JwtUtil;
import com.itshanhe.qiyunblogapi.util.MD5Util;
import com.itshanhe.qiyunblogapi.util.TimeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理  API + Web版本
 * @author 山河
 * @version 1.0
 */
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    
    @Autowired
    private BlogUserService blogUserService;
    @Autowired
    private MailService mailService;
    @Autowired
    private DomainUtil domainUtil;
//    默认报错为null
    private String paramError = null;
//    是否开启邮箱验证 默认为false
    @Value("${email.test:false}")
    private Boolean emailIF;
    
    /**
     * 用户注册
     * @param blogRegisterParam 注册信息
     * @param result 数据校验错误信息（自动）
     * @return 注册结果
     */
    @PostMapping("register")
    public Result register(@RequestBody @Valid BlogRegisterParam blogRegisterParam, BindingResult result) {
//        if (blogRegisterParam == null) {
//            return Result.success("请提交参数");
//        }
//            log.info("名字{}",blogRegisterParam);
//        数据校验错误信息
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                this.paramError = (error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        if (this.paramError != null) {
            return Result.error(this.paramError);
        }
        
//        临时验证
        if (blogUserService.userCount() > 50) {
            return Result.error("注册已经到上限");
        }

//            获取返回值
        int resultUser = blogUserService.userRegister(blogRegisterParam.getUserUsername(), MD5Util.Md5Code(blogRegisterParam.getUserPassword()), blogRegisterParam.getUserNickName(),blogRegisterParam.getUserEmail());
        if (resultUser == -1) {
            return Result.success("用户名已经被注册了");
        } else if (resultUser == 0) {
            return Result.success("未知错误，请联系系统管理员");
        }
        
//        获取ID
        String getUserId = blogUserService.userGetId(blogRegisterParam.getUserUsername());
//        MD5加密ID
        String md5Id = MD5Util.Md5Code(getUserId);
        //        临时邮箱验证
        if (this.emailIF) {
            //        发送邮箱验证码
//        需要发送的QQ邮箱
            String to = blogRegisterParam.getUserEmail();
//        发送主题
            String subject = "七云博客邮箱验证";
//        发送的HTML内容 并且设置过期时间为10分钟
            String text = "<h1>七云博客邮箱验证</h1><p>欢迎注册七云博客,请点击以下链接进行注册.</p><p>"+domainUtil.getDomain()+"user/emailVerify/"+ TimeUtil.getSetCurrentTime(10) +"/name="+blogRegisterParam.getUserUsername()+"&md5="+md5Id+"</p>";
            log.info("邮件发送前{},tex:{}",to,text);
            if (mailService.sendHtmlMail(to,subject,text) == -1) {
                log.debug("邮箱有问题");
//            删除用户
                blogUserService.userDeleteName(blogRegisterParam.getUserUsername());
                return Result.error("邮箱发送失败,请重新注册填写注册");
            }
        }

        
        return Result.success("注册成功！请在邮箱里点击验证才能完成注册.");
    }
    
    /**
     * 用户登录
     * @param blogLoginParam 登陆信息
     * @param result 数据校验错误信息（自动）
     * @return 颁发一个token令牌
     */
    @PostMapping("login")
    public Result login(@RequestBody @Valid BlogLoginParam blogLoginParam, BindingResult result) {
        //        数据校验错误信息
        log.info("登录测试");
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                this.paramError = (error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        if (this.paramError != null) {
            return Result.error(this.paramError);
        }
        BlogUser userLogin = blogUserService.userLogin(blogLoginParam.getUserUsername(),MD5Util.Md5Code(blogLoginParam.getUserPassword()));
        if (userLogin == null) {
            return Result.error("账号或密码错误");
        }
//        验证用户是否是锁定状态
        if (userLogin.getUserLocked() == 1) {
            return Result.error("你的账号已经被锁定");
        }
//        验证完之后颁发token令牌 令牌默认24小时后过期
        Map<String,Object> claims =new HashMap<>();
//        发给前端的ID -1000 因为SQL里面设置的是1000开头
        claims.put("uuid",(userLogin.getUserId()-1000));
        claims.put("name",userLogin.getUserUsername());
        claims.put("nickname",userLogin.getUserNickName());
        String JwtToken = JwtUtil.generateJwt(claims);
        log.debug("token令牌{}",claims);
//        写入数据库
        blogUserService.userSetToken(userLogin.getUserId(),JwtToken);
        log.debug("token记录数据库成功");
//        返回token令牌
        return Result.success("登陆成功，返回Token令牌",JwtToken);
    }
    
    /**
     * 验证用户注册,用户需要点击才能完成注册
     * @param longTime 简单的时间戳
     * @param name 用户账号
     * @param md5 由ID加密得到的校验码
     * @return 验证注册完成信息
     */
    @GetMapping("/emailVerify/{longTime}/name={name}&md5={md5}")
    public Result emailVerify(@PathVariable Long longTime,@PathVariable String name,@PathVariable String md5) {
//        获取现在时间然后判断过期时间,是否过期了
        if (TimeUtil.getNowCurrentTime()>longTime) {
            return Result.error("该链接已经过期了");
        }
//        先给空值防止报错
        String id = null;
        id = blogUserService.userGetId(name);
//        验证一下是否注册了
        if (id == null) {
            return Result.error("你没进行注册");
        }
//        MD5加密ID
        String md5id = MD5Util.Md5Code(id);
//        校验MD5 ID
        if (!md5.equals(md5id)) {
            return Result.error("MD5校验码错误，非法用户");
        }
//        查询是否是锁定状态 如果已经没锁定就返回注册完成
        if (blogUserService.userLocked(id) == 0) {
            return Result.error("你已经注册完了,请不要再次注册!");
        }
//        更改锁定状态 更改为解锁
        blogUserService.setLocked(id,0);
        return Result.success("注册成功!");
    }
    
    /**
     * 更改用户信息 API部分
     * @param blogUpdateParam
     * @param result
     * @return
     */
    @PostMapping("updateApiUser")
    public Result updateUserContent(@RequestBody @Valid BlogUpdateParam blogUpdateParam, BindingResult result) {
//        数据校验错误信息
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                this.paramError = (error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        if (this.paramError != null) {
            return Result.error(this.paramError);
        }
        //为了防止不是Web端访问,所以单独要判断一个Token并且校验token
//        +1000是因为令牌我发回去的时候是-1000的情况
        if (blogUserService.userTokenStatus((blogUpdateParam.getUserID()+1000),blogUpdateParam.getToken()) == -1) {
            return Result.error("Token过期或者不存在",-1);
        }
//        更改个人信息 复杂SQL语句，暂时不写
        
        return Result.success("更改成功");
    }
    
    /**
     * 更改用户信息 web
     * @param blogUpdateUser
     * @param result
     * @return
     */
    @PostMapping("updateUser")
    public Result updateUserContent(@RequestBody @Valid BlogUpdateUser blogUpdateUser, BindingResult result) {
//        数据校验错误信息
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                this.paramError = (error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
        if (this.paramError != null) {
            return Result.error(this.paramError);
        }
        
//        更改个人信息 复杂SQL语句，暂时不写
        
        return Result.success("更改成功");
    }
    
    /**
     * 后台用户查询,默认查询用户 未完成
     * @param page 默认1
     * @param pageSize 默认 10 条
     * @param token 令牌
     * @return
     */
    @GetMapping("list/{token}")
    public Result userQueryAllData(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "10") Integer pageSize,@PathVariable String token) {
//        解析token 令牌 获取令牌数据
        TokenData tokenData = blogUserService.TokenData(token);
//        获取用户权限
        int userType = blogUserService.userType(tokenData.getUuid());
        log.debug("权限:{}",userType);
        return Result.success("ok");
    }
}
