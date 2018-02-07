package com.funcodeh.shiro.demo.controller;

import com.funcodeh.shiro.demo.dto.ResultDto;
import com.funcodeh.shiro.demo.service.UserService;
import com.funcodeh.shiro.demo.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Function: TODO: ADD FUNCTION <br>
 *
 * @Author: funcodeh <br>
 * @Date: 2018-02-07 下午2:33
 */
@RestController
@RequestMapping("/api/user")
@Api(description = " ", tags = "003、用户管理")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("添加用户信息")
    public ResultDto addUser(@RequestBody @ApiParam(value = "添加新用户", required = true) UserDto userDto){

        return userService.insertUser(userDto);
    }
}
