package com.hukaihan.security.login.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    /**
     * 功能描述 ：
     * @author HKH
     * @date
     * @param
     * @return
     */
   String login(String userName, String pwd, HttpServletRequest request);
}
