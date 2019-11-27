package com.hukaihan.security.webConfig.filter;


import com.hukaihan.security.login.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: security
 * @description: None
 * @author: HKH
 * @create: 2019-11-27 09:42
 **/

@Order(1)
public class SessionFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(SessionFilter.class);


    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("身份认证过滤器初始化...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        logger.info("身份认证开始执行逻辑");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null){
            logger.info("身份认证通过");
            filterChain.doFilter(request,response);
        }else{
            PrintWriter writer = response.getWriter();
            writer.println("Please Login Now !");
            logger.info("身份认证未通过不允访问");
        }

    }
}
