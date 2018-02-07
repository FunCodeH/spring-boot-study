package com.funcodeh.shiro.demo.core.filter;


import com.funcodeh.shiro.demo.core.logger.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Function: 打印出当前访问的api接口以及耗时 <br>
 *
 * @Author: funcodeh <br>
 * @Date: 2018-01-27 上午11:16
 */
@WebFilter(filterName = "apiLogFilter", urlPatterns = "/user/*",initParams = {})
public class ApiLogFilter implements Filter{
    private Logger logger = Logger.getLogger(this.getClass());


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getMethod() + " " + req.getRequestURI();

        logger.info("\r\napi-start---" + url);
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        long end = System.currentTimeMillis();
        logger.info("\r\napi-end-----" + url +"         耗时："+(end-start)+"ms \r\n\r\n\r\n");
    }

    @Override
    public void destroy() {

    }
}
