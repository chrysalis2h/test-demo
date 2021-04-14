package com.cycle.rubbish.demo.DesignPatterns.state;

/**
 * @ClassName: StateDemo
 * @Description: Allow an object to alter its behavior when its internal state changes.The object will appear to change its class;
 * 当一个对象内在状态改变时，允许其行为改变，这个对象看起来就像改变了其类。
 * @Author: HJ
 * @Date: 2021/1/12 21:02
 * @Version: v1.0 文件初始创建
 */
public class StateDemo {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext();
        stateContext.setCurrentState(StateContext.HANDLE1);
        stateContext.handle1();
        stateContext.handle2();

    }
}
