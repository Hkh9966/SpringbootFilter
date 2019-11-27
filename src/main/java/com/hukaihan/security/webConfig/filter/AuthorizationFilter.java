package com.hukaihan.security.webConfig.filter;

import com.hukaihan.security.login.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * @program: security
 * @description: None
 * @author: HKH
 * @create: 2019-11-27 09:43
 **/

@Order(2)
public class AuthorizationFilter implements Filter {


    public static final String SPLITER = "-";


    private static final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("授权过滤器");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean hasPermission = false;

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        logger.info("授权开始执行逻辑");
        HttpSession session =  request.getSession();
        String requestURI = request.getRequestURI();

        User user = (User)session.getAttribute("user");
        logger.info("用户:{}将要访问接口:{}",user.getUserName(),requestURI);

        String permissionStr = (String)session.getAttribute("permissionList");
        String[] permissions = permissionStr.split(SPLITER);


        for (int i = 0; i < permissions.length; i++) {
            if(requestURI.equals(permissions[i])){
                hasPermission = true;
                filterChain.doFilter(request,response);
            }
        }

        if(!hasPermission){
            PrintWriter writer = response.getWriter();
            writer.println("No Permission For this URI !");
        }

    }
}
