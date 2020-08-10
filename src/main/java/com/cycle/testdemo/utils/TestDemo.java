package com.cycle.testdemo.utils;

import java.lang.reflect.Method;

/**
 *  * @ClassName: TestDemo
 *  * @Description: TestDemo
 *  * @Author: HeJin
 *  * @Date: 2019\12\18 0018 14:56
 *  * @Version: v1.0 文件初始创建
 */
public class TestDemo {

    public static void main(String[] args) throws Exception {
        Class testDemo = Class.forName("com.cycle.testdemo.utils.TestDemo");
        Method method = testDemo.getMethod("target", String.class);
        method.invoke(null, "HHHHHH");
    }

    public static void target(String str){
        new Exception("#" + str).printStackTrace();
        System.out.println("invoke target method");
    }
}
