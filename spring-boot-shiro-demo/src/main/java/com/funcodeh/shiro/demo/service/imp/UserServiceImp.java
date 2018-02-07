package com.funcodeh.shiro.demo.service.imp;

import com.funcodeh.shiro.demo.core.utils.CredentialUtils;
import com.funcodeh.shiro.demo.dto.ResultDto;
import com.funcodeh.shiro.demo.dto.UserDto;
import com.funcodeh.shiro.demo.mapper.UserMapper;
import com.funcodeh.shiro.demo.service.UserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.funcodeh.shiro.demo.entity.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Function: TODO: ADD FUNCTION <br>
 *
 * @Author: funcodeh <br>
 * @Date: 2018-02-07 下午2:55
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册插入新用户
     * @param userDto
     * @return
     */
    @Override
    public ResultDto insertUser(UserDto userDto) {

        String userName = userDto.getUserName();

        if(null != userMapper.selectByUserName(userName)){
            return new ResultDto("用户名已存在", "");
        }
        User user = new User();
        user.setUserName(userName);

        //密码使用Md5加密，盐值使用UUID产生
        String credentialSalt = CredentialUtils.generateSalt();
        user.setSalt(credentialSalt);
        user.setPassword(new Md5Hash(userDto.getPassword(), credentialSalt).toString().toUpperCase());
        user.setCreatetime(new Date());
        userMapper.insert(user);

        return new ResultDto("添加用户成功", "");
    }
}
