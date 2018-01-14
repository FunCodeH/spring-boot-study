package com.funcodeh.mybatis.demo.service;

import com.funcodeh.mybatis.demo.entity.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    List<User> findAllUser(int pageNum, int pageSize);
}
