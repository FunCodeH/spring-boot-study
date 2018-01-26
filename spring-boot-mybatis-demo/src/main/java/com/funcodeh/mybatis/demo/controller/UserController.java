package com.funcodeh.mybatis.demo.controller;

import com.funcodeh.mybatis.demo.entity.User;
import com.funcodeh.mybatis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService  userService;

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(){
        return "this is mybatis demo";
    }

    @RequestMapping(value = "/add",  method = RequestMethod.GET)
    public int addUser(){
        System.out.println("good");
        User user = new User();
        user.setUserName("A");
        user.setEmail("aaa");
        user.setMobile("1");
        user.setIsdelete(0);
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }
}
