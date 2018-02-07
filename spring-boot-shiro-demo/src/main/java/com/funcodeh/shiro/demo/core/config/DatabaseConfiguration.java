package com.funcodeh.shiro.demo.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.funcodeh.shiro.demo.core.logger.Logger;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Function: TODO: ADD FUNCTION <br>
 *
 * @Author: funcodeh <br>
 * @Date: 2018-01-26 下午3:59
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration implements EnvironmentAware {
    private static final Logger logger = Logger.getLogger(DatabaseConfiguration.class);
    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
    }

    @Bean(destroyMethod = "close", initMethod = "init")
    public DataSource writeDataSource() {
        logger.info("使用druid数据源");

        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(propertyResolver.getProperty("url"));
        datasource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        datasource.setUsername(propertyResolver.getProperty("username"));
        datasource.setPassword(propertyResolver.getProperty("password"));
        datasource.setInitialSize(Integer.parseInt(propertyResolver.getProperty("initialSize")));
        datasource.setMinIdle(Integer.parseInt(propertyResolver.getProperty("minIdle")));
        datasource.setMaxWait(Long.parseLong(propertyResolver.getProperty("maxWait")));
        datasource.setMaxActive(Integer.parseInt(propertyResolver.getProperty("maxActive")));
        datasource.setMinEvictableIdleTimeMillis(Long.parseLong(propertyResolver.getProperty(
                "minEvictableIdleTimeMillis")));
        try {
            datasource.setFilters(propertyResolver.getProperty("filters"));
        } catch (SQLException e) {
            throw new RuntimeException("添加过滤异常" + e);
        }
        return datasource;
    }

    @Bean(name = "druid-stat-interceptor")
    public DruidStatInterceptor setDruidStatInterceptor() {
        return new DruidStatInterceptor();
    }

    @Bean(name = "druid-stat-pointcut")
    public JdkRegexpMethodPointcut setJdkRegexpMethodPointcut() {
        JdkRegexpMethodPointcut jdk = new JdkRegexpMethodPointcut();
        jdk.setPatterns("com.funcodeh.mybatis.demo.*");
        return jdk;
    }
}
