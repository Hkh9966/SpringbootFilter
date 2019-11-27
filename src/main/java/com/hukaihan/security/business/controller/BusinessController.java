package com.hukaihan.security.business.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: security
 * @description: None
 * @author: HKH
 * @create: 2019-11-27 10:38
 **/
@RestController
@RequestMapping("/api/")
public class BusinessController {

    @GetMapping("test1")
    public String test(){
        return "普通业务操作";
    }

    @GetMapping("test2")
    public String test2(){
        return "需要管理员权限的敏感操作";
    }
}
