package com.cycle.testdemo.test.mybatis;

/**
 * @Description: 测试org/apache/ibatis/logging/LogFactory.java
 * @Date: 2020\10\26 0026 14:50
 * @Author: HJ
 * @Return 
 * @Throws 
 */
public class LogFactoryTest {
    private static String logConstructor;
    static {
        //这边乍一看以为开了几个并行的线程去决定使用哪个具体框架的logging，其实不然
        //slf4j
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                System.out.println("start-useSlf4jLogging-useSlf4jLogging-useSlf4jLogging");
                useSlf4jLogging();
                System.out.println("end-useSlf4jLogging-useSlf4jLogging-useSlf4jLogging");
            }
        });
        //common logging
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                System.out.println("start-useCommonsLogging-useCommonsLogging-useCommonsLogging");
                useCommonsLogging();
                System.out.println("end-useCommonsLogging-useCommonsLogging-useCommonsLogging");
            }
        });
        //log4j2
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                System.out.println("start-useLog4J2Logging-useLog4J2Logging-useLog4J2Logging");
                useLog4J2Logging();
                System.out.println("end-useLog4J2Logging-useLog4J2Logging-useLog4J2Logging");
            }
        });
        //log4j
        tryImplementation(new Runnable() {
            @Override
            public void run() {
                System.out.println("start-useLog4JLogging-useLog4JLogging-useLog4JLogging");
                useLog4JLogging();
                System.out.println("end-useLog4JLogging-useLog4JLogging-useLog4JLogging");
            }
        });
    }

    public static synchronized void useSlf4jLogging() {
        setImplementation("useSlf4jLogging");
    }

    public static synchronized void useCommonsLogging() {
        setImplementation("useCommonsLogging");
    }

    public static synchronized void useLog4JLogging() {
        setImplementation("useLog4JLogging");
    }

    public static synchronized void useLog4J2Logging() {
        setImplementation("useLog4J2Logging");
    }
    private static void tryImplementation(Runnable runnable) {
        if (logConstructor == null) {
            try {
                //这里调用的不是start,而是run！根本就没用多线程嘛！
                runnable.run();
                System.out.println("run-------------");
            } catch (Throwable t) {
                // ignore
            }
        }
    }

    private static void setImplementation(String result) {
        try {
            logConstructor = result;
            System.out.println(logConstructor);
        } catch (Throwable t) {
            System.out.println("exception");
        }
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
