package com.hukaihan.security.login.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: security
 * @description: None
 * @author: HKH
 * @create: 2019-11-27 11:25
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Permission {

    private Integer permissionId;

    private String permissionName;

    private String permissionUrl;

}
