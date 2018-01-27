package com.funcodeh.mybatis.demo.core.logger;

import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/**
 * Function: TODO: ADD FUNCTION <br>
 *
 * @Author: HeWenBo <br>
 * @Date: 2018-01-26 下午4:02
 */
public class Logger {
    private org.slf4j.Logger logger;
//  protected org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 构造方法，初始化Log4j的日志对象
     */
    private Logger(org.slf4j.Logger log4jLogger) {
        logger = log4jLogger;
    }

    /**
     * 获取构造器，根据类初始化Logger对象
     *
     * @return Logger对象
     */
    public static Logger getLogger(Class classObject) {
        return new Logger(LoggerFactory.getLogger(classObject));
    }

    /**
     * 获取构造器，根据类名初始化Logger对象
     *
     * @return Logger对象
     */
    public static Logger getLogger(String loggerName) {
        return new Logger(LoggerFactory.getLogger(loggerName));
    }

    public void trace(Object object) {
        logger.trace("", object);
    }

    public boolean isTraceEnabled(Marker var1) {
        return logger.isTraceEnabled(var1);
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }


    public void debug(Object object) {
        logger.debug("", object);

    }

    public void debug(String str) {
        logger.debug(str);

    }

    public void debug(Object object, Throwable e) {
        logger.debug("", object, e);
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }


    public void info(String str) {
        logger.info(str);
    }

    public void info(String var1, Object object) {
        logger.info("{}", object);
    }

    public void info(Object object, Throwable e) {
        logger.info("", object, e);
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public void warn(String str) {
        logger.warn(str);
    }

    public void warn(Object object, Throwable e) {
        logger.warn("", object, e);
    }

    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public void error(String str) {
        logger.error(str);
    }

    public void error(String msg, Throwable t) {
        logger.error(msg, t);
    }

    public void error(Object object, Throwable e) {
        logger.error("", object, e);
    }


    public String getName() {
        return logger.getName();
    }

    public org.slf4j.Logger getLog4jLogger() {
        return logger;
    }
}
