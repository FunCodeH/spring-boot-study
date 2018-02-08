package com.funcodeh.shiro.demo.security;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Function: TODO: ADD FUNCTION  <br>
 * Author: funcodeh <br>
 * Date: 2018-02-06 17:46:00
 */
public abstract class AbstractShiroConfiguration {

    protected ShiroFilterFactoryBean createShiroFilterFactoryBean(SecurityManager securityManager,
                                                                  Map<String, String> filterChainDefinitionMap) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    public abstract AbstractUserRealm createUserRealm();

    /**
     * 不指定名字的话，自动创建一个方法名第一个字母小写的bean
     *
     * @return
     * @Bean(name = "securityManager")
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        List<Realm> reams = new ArrayList<>();
        reams.add(createUserRealm());
        securityManager.setRealms(reams);
        return securityManager;
    }

    public abstract HashedCredentialsMatcher hashedCredentialsMatcher();

}