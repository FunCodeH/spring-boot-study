package com.funcodeh.mybatis.demo.controller;

import com.funcodeh.mybatis.demo.dto.UserDto;
import com.funcodeh.mybatis.demo.entity.User;
import com.funcodeh.mybatis.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(description = " ", tags = "001、用户管理")
public class UserController {
    @Autowired
    private UserService  userService;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(){
        return "this is mybatis demo";
    }

    @ApiOperation(value = "添加用户")
    @RequestMapping(value = "/serch" , method = RequestMethod.POST)
    public int addUser(@RequestBody @ApiParam(value="添加新用户", required = true) UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userService.addUser(user);
    }

    @ApiOperation(value = "查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "分页",required = false, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "分页",required = false, dataType = "int", paramType = "query")
    })
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Object findAllUser(@RequestParam(required = false, defaultValue = "1") int pageNum,
                              @RequestParam(required = false, defaultValue = "10") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }
}
