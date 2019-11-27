package com.hukaihan.security.login.controller;

import com.hukaihan.security.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: security
 * @description: None
 * @author: HKH
 * @create: 2019-11-27 10:00
 **/
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/{name}/{pwd}")
    public String login(@PathVariable("name") String name, @PathVariable("pwd") String pwd, HttpServletRequest httpServletRequest){
        return userService.login(name,pwd,httpServletRequest);
    }

}
