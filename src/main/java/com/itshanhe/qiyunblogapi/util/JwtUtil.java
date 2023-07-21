package com.itshanhe.qiyunblogapi.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * jwt 生成和解析
 */
public class JwtUtil {
    //    签名算法
    private static String signKey = "qiyunblog";
    //    过期时间 24小时
    private static Long expire = System.currentTimeMillis() + (3600*100) *24;
    
    /**
     *生产Jwt
     * @param claims 令牌的公共 json数据
     * @return token令牌
     */
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .addClaims(claims) //令牌的公共 json 数据
                .signWith(SignatureAlgorithm.HS256, signKey) //签名算法+密钥
                .setExpiration(new Date(System.currentTimeMillis() + expire)) //过期时间
                .compact(); //获取返回值
        return jwt;
    }
    
    /**
     * 解析jwt令牌
     * @param jwt 令牌
     * @return 公共json数据
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey) //密钥
                .parseClaimsJws(jwt) // 令牌
                .getBody(); //获取内容
        return claims;
    }
}
