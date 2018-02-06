package com.funcodeh.shiro.demo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Function: TODO: ADD FUNCTION  <br>
 * Author: funcodeh <br>
 * Date: 2018-02-06 17:46:00
 */
@RestController
public class LoginController {

    public static final String UNKNOWN = "unknown";

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(HttpServletRequest request) throws Exception {
        String username = "Li";
        String password = "123";
        //记录当前用户到session，方便后续使用
        SecurityUtils.getSubject().getSession().setAttribute("username", username);

        //获取当前的Subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录过程
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,重写此方法实现用户名密码验证
            subject.login(token);
        } catch (UnknownAccountException uae) {
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
        } catch (IncorrectCredentialsException ice) {

            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,未知账户密码");

        } catch (LockedAccountException lae) {

            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,账户锁定");
        } catch (ExcessiveAttemptsException eae) {

            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");

        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            System.out.println("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下" + ae.toString());
        }
        //验证是否登录成功
        if (subject.isAuthenticated()) {
            System.out.println("用户[" + username + "]登录认证通过");
        } else {
            token.clear();
        }
        return "loginSuccess";
    }
}
