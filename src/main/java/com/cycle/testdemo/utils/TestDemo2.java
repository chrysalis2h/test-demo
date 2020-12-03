package com.cycle.testdemo.utils;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogException;
import org.apache.ibatis.logging.LogFactory;

import java.lang.reflect.Constructor;

/**
 *  * @ClassName: TestDemo
 *  * @Description: TestDemo
 *  * @Author: HeJin
 *  * @Date: 2019\12\18 0018 14:56
 *  * @Version: v1.0 文件初始创建
 */
public class TestDemo2 {
    /**
     * Marker to be used by logging implementations that support markers
     */
    //给支持marker功能的logger使用(目前有slf4j, log4j2)
    public static final String MARKER = "MYBATIS";

    //具体究竟用哪个日志框架，那个框架所对应logger的构造函数
    private static Constructor<? extends Log> logConstructor;

    static {
        //这边乍一看以为开了几个并行的线程去决定使用哪个具体框架的logging，其实不然
        //slf4j
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                useSlf4jLogging();
            }
        });
        //common logging
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                useCommonsLogging();
            }
        });
        //log4j2
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                useLog4J2Logging();
            }
        });
        //log4j
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                useLog4JLogging();
            }
        });
        //jdk logging
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                useJdkLogging();
            }
        });
        //没有日志
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                useNoLogging();
            }
        });
    }

    //根据传入的类来构建Log
    public static Log getLog(Class<?> aClass) {
        return getLog(aClass.getName());
    }

    //根据传入的类名来构建Log
    public static Log getLog(String logger) {
        try {
            //构造函数，参数必须是一个，为String型，指明logger的名称
            return logConstructor.newInstance(new Object[] { logger });
        } catch (Throwable t) {
            throw new LogException("Error creating logger for logger " + logger + ".  Cause: " + t, t);
        }
    }

    //提供一个扩展功能，如果以上log都不满意，可以使用自定义的log
    public static synchronized void useCustomLogging(Class<? extends Log> clazz) {
        setImplementation(clazz);
    }

    public static synchronized void useSlf4jLogging() {
        setImplementation(org.apache.ibatis.logging.slf4j.Slf4jImpl.class);
    }

    public static synchronized void useCommonsLogging() {
        setImplementation(org.apache.ibatis.logging.commons.JakartaCommonsLoggingImpl.class);
    }

    public static synchronized void useLog4JLogging() {
        setImplementation(org.apache.ibatis.logging.log4j.Log4jImpl.class);
    }

    public static synchronized void useLog4J2Logging() {
        setImplementation(org.apache.ibatis.logging.log4j2.Log4j2Impl.class);
    }

    public static synchronized void useJdkLogging() {
        setImplementation(org.apache.ibatis.logging.jdk14.Jdk14LoggingImpl.class);
    }

    //这个没用到
    public static synchronized void useStdOutLogging() {
        setImplementation(org.apache.ibatis.logging.stdout.StdOutImpl.class);
    }

    public static synchronized void useNoLogging() {
        setImplementation(org.apache.ibatis.logging.nologging.NoLoggingImpl.class);
    }

    private static void tryImplementation(Runnable runnable) {
        if (logConstructor == null) {
            try {
                //这里调用的不是start,而是run！根本就没用多线程嘛！
                runnable.run();
            } catch (Throwable t) {
                // ignore
            }
        }
    }

    private static void setImplementation(Class<? extends Log> implClass) {
        try {
            Constructor<? extends Log> candidate = implClass.getConstructor(new Class[] { String.class });
            Log log = candidate.newInstance(new Object[] { LogFactory.class.getName() });
            log.debug("Logging initialized using '" + implClass + "' adapter.");
            System.out.println("Logging initialized using '" + implClass + "' adapter.");
            //设置logConstructor,一旦设上，表明找到相应的log的jar包了，那后面别的log就不找了。
            logConstructor = candidate;
        } catch (Throwable t) {
            throw new LogException("Error setting Log implementation.  Cause: " + t, t);
        }
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
