package com.cycle.testdemo.demo.DesignPatterns.state;

/**
 * @ClassName: BaseState
 * @Description: 抽象状态角色--接口或抽象类，负责对象状态的定义，并且封装环境类来实现状态的切换
 * @Author: HJ
 * @Date: 2021/1/12 20:48
 * @Version: v1.0 文件初始创建
 */
public abstract class BaseState {

    //定义环境类，来实现状态的切换
    protected StateContext stateContext;

    public void setStateContext(StateContext stateContext) {
        this.stateContext = stateContext;
    }

    // 定义处理方法1
    public abstract void handle1();

    // 定义处理方法2
    public abstract void handle2();
}
