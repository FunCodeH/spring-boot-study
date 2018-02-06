package com.funcodeh.shiro.demo.security;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.AuthorizingRealm;


/**
 * Function: TODO: ADD FUNCTION  <br>
 * Author: funcodeh <br>
 * Date: 2018-02-06 17:46:00
 */
public abstract class AbstractUserRealm extends AuthorizingRealm {

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }
}

