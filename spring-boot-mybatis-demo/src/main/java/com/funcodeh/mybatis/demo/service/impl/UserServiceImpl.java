package com.funcodeh.mybatis.demo.service.impl;

import com.funcodeh.mybatis.demo.entity.User;
import com.funcodeh.mybatis.demo.mapper.UserMapper;
import com.funcodeh.mybatis.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectAllUser();
        for (User user : list) {
            System.out.println(user);
        }
        return  null;
    }
}
