package com.funcodeh.mybatis.demo.controller;

import com.funcodeh.mybatis.demo.entity.User;
import com.funcodeh.mybatis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService  userService;

    @RequestMapping
    public void say(){

    }

    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public int addUser(User user){
        System.out.println("good");
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return userService.findAllUser(pageNum,pageSize);
    }
}
