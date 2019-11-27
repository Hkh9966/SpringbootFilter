package com.hukaihan.security.login.dao;

import com.hukaihan.security.login.pojo.Permission;
import com.hukaihan.security.login.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from user where user_name = #{value}")
    User findUser(String userName);

    @Select("SELECT p.permission_id,p.permission_name,p.permission_url " +
            "FROM  user_permission up " +
            "left join permission p on up.permission_id = p.permission_id where user_id = #{value}")
    List<Permission> findPermissionByUserId(String uid);

}
