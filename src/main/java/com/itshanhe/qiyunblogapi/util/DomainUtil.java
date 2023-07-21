package com.itshanhe.qiyunblogapi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class DomainUtil {
    
    // 从配置文件中获取项目的端口号，默认为8080
    @Value("${server.port:8080}")
    private int serverPort;
    
    // 从配置文件中获取项目的上下文路径，默认为空
    @Value("${server.servlet.context-path:}")
    private String contextPath;
    
    // 自动注入HttpServletRequest对象
    @Autowired
    private HttpServletRequest request;
    
    // 获取本项目的域名
    public String getDomain() {
        // 获取请求的协议
        String protocol = request.getScheme();
        
        // 获取请求的主机名
        String host = request.getServerName();
        
        // 构建域名字符串
        StringBuilder domainBuilder = new StringBuilder();
        domainBuilder.append(protocol).append("://").append(host);
        
        // 如果端口号不是默认的80或443，则添加端口号
        if ((protocol.equals("http") && serverPort != 80) || (protocol.equals("https") && serverPort != 443)) {
            domainBuilder.append(":").append(serverPort);
        }
        
        // 如果有上下文路径，则添加上下文路径
        if (!contextPath.isEmpty()) {
            domainBuilder.append(contextPath);
        }
        
        return domainBuilder.toString();
    }
}
