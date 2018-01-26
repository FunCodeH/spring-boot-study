package com.funcodeh.mybatis.demo.service.impl;

import com.funcodeh.mybatis.demo.entity.User;
import com.funcodeh.mybatis.demo.mapper.UserMapper;
import com.funcodeh.mybatis.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        //PageHelper.startPage(pageNum, pageSize);
        //userMapper.selectAllUser();
        return  null;
    }
}
