package com.funcodeh.hello.say;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Function: TODO: ADD FUNCTION <br>
 *
 * @Author: HeWenBo <br>
 * @Date: 2018-01-12 下午8:20
 */
@RestController
@RequestMapping("hello")
public class sayController {

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say(){
        return "say you love spring-boot !!! ";
    }
}
