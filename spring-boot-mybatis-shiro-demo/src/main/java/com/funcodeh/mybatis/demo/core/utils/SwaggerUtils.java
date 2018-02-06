package com.funcodeh.mybatis.demo.core.utils;

import com.google.common.base.Predicate;
import springfox.documentation.RequestHandler;

public class SwaggerUtils {

    public static Predicate<RequestHandler> basePackages(final String[] basePackages){
        return input -> {
            if(input != null && basePackages != null && basePackages.length > 0){
                Class<?> cls = input.getHandlerMethod().getMethod().getDeclaringClass();
                String clsName = cls.getPackage().getName();
                for(String pkgName : basePackages){
                    if(clsName.startsWith(pkgName)){
                        return true;
                    }
                }
            }
            return false;
        };
    }
}
