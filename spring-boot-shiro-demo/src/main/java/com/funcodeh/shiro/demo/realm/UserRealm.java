package com.funcodeh.shiro.demo.realm;


import com.funcodeh.shiro.demo.entity.User;
import com.funcodeh.shiro.demo.mapper.UserMapper;
import com.funcodeh.shiro.demo.security.AbstractUserRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * Function: TODO: ADD FUNCTION  <br>
 * Author: funcodeh <br>
 * Date: 2018-02-06 17:46:00
 */
public class UserRealm extends AbstractUserRealm {

    @Autowired
    private UserMapper userMapper;
    /**
     * 授权用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        List<String> userRoles = new ArrayList<>();
        List<String> userPermissions = new ArrayList<>();

        userRoles.add("R0234");
        userPermissions.add("mgt");
        //为当前用户设置角色和权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRoles(userRoles);
        authorizationInfo.addStringPermissions(userPermissions);
        return authorizationInfo;
    }

    /**
     * 验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {

        System.out.println("###【开始认证[SessionId]】" + SecurityUtils.getSubject().getSession().getId());

        String username = (String) authcToken.getPrincipal();

        User user = userMapper.selectByUserName(username);
        if (user == null) {
            //没找到帐号
            throw new UnknownAccountException();
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getUserName(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                //realm name
                getName()
        );
        return authenticationInfo;
    }
}
