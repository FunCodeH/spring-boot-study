package com.funcodeh.shiro.demo.service;

import com.funcodeh.shiro.demo.dto.ResultDto;
import com.funcodeh.shiro.demo.dto.UserDto; /**
 * Function: TODO: ADD FUNCTION <br>
 *
 * @Author: funcodeh <br>
 * @Date: 2018-02-07 下午2:39
 */
public interface UserService {

    /**
     * 用户注册时，插入新用户
     */
    ResultDto insertUser(UserDto userDto);

    /**
     * 根据用户名删除用户
     */
    ResultDto deleteUser(String userName);
}
