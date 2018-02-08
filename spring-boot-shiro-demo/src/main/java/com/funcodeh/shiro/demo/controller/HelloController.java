package com.funcodeh.shiro.demo.controller;

import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Function: TODO: ADD FUNCTION  <br>
 * Author: funcodeh <br>
 * Date: 2018-02-06 17:46:00
 */
@RestController
@Api(description = " ", tags = "001、helloWorld")
@RequestMapping("/api/say")
public class HelloController {
    @RequiresPermissions("mgt")
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String Index() {
        return "hello world!";
    }
}