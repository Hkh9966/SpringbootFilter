package com.hukaihan.security;

import com.hukaihan.security.util.JWTUtil;
import com.hukaihan.security.util.MD5Util;
import com.nimbusds.jose.JOSEException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.interfaces.PBEKey;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class SecurityApplicationTests {

    @Test
    void contextLoads() throws JOSEException {
        Map<String, Object> map = new HashMap<>();
        map.put("userId","1");
        String token = JWTUtil.creatToken(map);
        System.out.println(token);
    }

}
