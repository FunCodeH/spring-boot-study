package com.funcodeh.shiro.demo.utils;

import java.util.UUID;

/**
 * Function: 使用UUID产生加密盐与随机密码 <br>
 *
 * @Author: funcodeh <br>
 * @Date: 2018-02-07 上午9:49
 */
public class CredentialUtils {
    public static String generateSalt() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid.substring(5, 11);
    }

    public static String randomPassword() {
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        return uuid.substring(5, 13);
    }
}
