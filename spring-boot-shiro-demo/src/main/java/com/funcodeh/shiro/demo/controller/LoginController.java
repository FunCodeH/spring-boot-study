package com.funcodeh.shiro.demo.controller;

import com.funcodeh.shiro.demo.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestBody;
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
@Api(description = " ", tags = "002、登录管理")
@RequestMapping("/api/login")
public class LoginController {

    public static final String UNKNOWN = "unknown";

    @ApiOperation(value = "登录")
    @RequestMapping(value="/loginIn",method= RequestMethod.POST)
    public String login(@RequestBody @ApiParam(value = "用户登录", required = true) UserDto userDto,
                        HttpServletRequest request) throws Exception {
        String username = userDto.getUserName();
        String password = userDto.getPassword();
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

    @ApiOperation("登出")
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) throws Exception {

        //仅退出已登录用户
        if (SecurityUtils.getSubject().isAuthenticated()) {

            String username = (String) SecurityUtils.getSubject().getPrincipal();
            System.out.println("用户[" + username + "]安全退出");
            //进行用户的退出，给出提示信息
            SecurityUtils.getSubject().logout();
        }
        return "loginOut";
    }
}
