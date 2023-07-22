package com.itshanhe.qiyunblogapi.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.itshanhe.qiyunblogapi.entity.Result;
import com.itshanhe.qiyunblogapi.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器
 */
@Slf4j
@Component
public class WebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        log.info("请求URL:{}",url);
//        url中是否包含以下参数 如果有就放行
        if (url.contains("/user/login") || url.contains("/user/register") || url.contains("/user/emailVerify") || url.contains("/user/updateUser")) {
            log.info("放行验证");
            return true;
        }
        
//3.获取请求头中的令牌（token）。
        String jwt = request.getHeader("token");
    
        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）。
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空,返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
    
        //5.解析token，如果解析失败，返回错误结果（未登录）。
        try {
            JwtUtil.parseJWT(jwt);
        } catch (Exception e) {//jwt解析失败
            e.printStackTrace();
            log.info("解析令牌失败, 返回未登录错误信息");
            Result error = Result.error("NOT_LOGIN");
            //手动转换 对象--json --------> 阿里巴巴fastJSON
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
    
        //6.放行。
        log.info("令牌合法, 放行");
        return true;
    }
}
