package com.funcodeh.shiro.demo.realm;


import com.funcodeh.shiro.demo.security.AbstractUserRealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;

import org.apache.shiro.subject.PrincipalCollection;


/**
 * Function: TODO: ADD FUNCTION  <br>
 * Author: funcodeh <br>
 * Date: 2018-02-06 17:46:00
 */
public class UserRealm extends AbstractUserRealm {

    /**
     * 授权用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        return info;
    }

    /**
     * 验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {

        System.out.println("###【开始认证[SessionId]】" + SecurityUtils.getSubject().getSession().getId());

        String username = (String) authcToken.getPrincipal();

        if(!"zhang".equals(username)) {
            //如果用户名错误
            throw new UnknownAccountException();
        }

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                "zhang",
                //密码
                "123",
                //realm name
                getName()
        );
        return authenticationInfo;
    }
}
