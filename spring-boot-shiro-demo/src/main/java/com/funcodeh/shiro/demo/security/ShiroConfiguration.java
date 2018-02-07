package com.funcodeh.shiro.demo.security;

import com.funcodeh.shiro.demo.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Function: TODO: ADD FUNCTION  <br>
 * Author: funcodeh <br>
 * Date: 2018-02-06 17:46:00
 */
@Configuration
public class ShiroConfiguration extends AbstractShiroConfiguration {

    /**
     * Shiro的Web过滤器Factory 命名:shiroFilter<br />
     *
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        /*定义shiro过滤器,例如实现自定义的FormAuthenticationFilter，需要继承FormAuthenticationFilter
        */
        /*定义shiro过滤链  Map结构
         * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于HttpServletRequest.getContextPath()的值来的
         * anon：它对应的过滤器里面是空的,什么都没做,这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种
         * authc：该过滤器下的页面必须验证后才能访问,它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        return createShiroFilterFactoryBean(securityManager, filterChainDefinitionMap);
    }

    /**
     * Shiro Realm
     */
    @Override
    @Bean
    public UserRealm createUserRealm() {
        UserRealm userRealm = new UserRealm();
        //告诉realm,使用credentialsMatcher加密算法类来验证密文
        //userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        //userRealm.setCachingEnabled(false);
        return userRealm;
    }


}
