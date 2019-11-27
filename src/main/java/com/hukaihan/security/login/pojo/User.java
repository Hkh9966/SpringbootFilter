package com.hukaihan.security.login.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: security
 * @description: None
 * @author: HKH
 * @create: 2019-11-27 10:04
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userId;

    private String userName;

    private String pwd;

}
