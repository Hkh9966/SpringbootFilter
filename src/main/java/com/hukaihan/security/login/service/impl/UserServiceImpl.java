package com.hukaihan.security.login.service.impl;

import com.hukaihan.security.login.dao.UserDao;
import com.hukaihan.security.login.pojo.Permission;
import com.hukaihan.security.login.pojo.User;
import com.hukaihan.security.login.service.UserService;
import com.hukaihan.security.util.MD5Util;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: security
 * @description: None
 * @author: HKH
 * @create: 2019-11-27 10:18
 **/
@Service
public class UserServiceImpl implements UserService {

    public static final String SPLITER = "-";


    @Autowired
    UserDao userDao;

    @Override
    public String login(String userName, String pwd, HttpServletRequest request) {
        if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(pwd)){
            return "用户名或密码不能为空";
        }
        User user = userDao.findUser(userName);
        if(user!=null){
            String code = MD5Util.getMd5Code(pwd + userName);
            if(code.equals(user.getPwd())){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                session.setAttribute("permissionList",setPermissionList(user.getUserId()));
                return "登陆成功";
            }else{
                return "用户名或密码错误！";
            }
        }else{
            return "用户名或密码错误！";
        }
    }

    private String setPermissionList(String uid){
        List<Permission> permissions = userDao.findPermissionByUserId(uid);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <permissions.size() ; i++) {
            sb.append(permissions.get(i).getPermissionUrl());
            if(i!=permissions.size()-1){
                sb.append("-");
            }
        }
        return sb.toString();
    }

}
