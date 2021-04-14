package com.cycle.rubbish.demo.DesignPatterns.state;

/**
 * @ClassName: StateContext
 * @Description: 环境角色--定义客户端需要的接口；负责具体状态的切换
 * @Author: HJ
 * @Date: 2021/1/12 20:55
 * @Version: v1.0 文件初始创建
 */
public class StateContext {

    // 定义具体的状态，有多少状态就定义多少
    public static final BaseState HANDLE1 = new ConcreteStateHandle1();
    public static final BaseState HANDLE2 = new ConcreteStateHandle2();

    private BaseState currentState;

    public BaseState getCurrentState() {
        return currentState;
    }

    // 设置上具体的状态，并将状态赋给抽象状态
    public void setCurrentState(BaseState baseState) {
        this.currentState = baseState;
        this.currentState.setStateContext(this);
    }

    // 行为委托具体的状态去执行
    public void handle1() {
        this.currentState.handle1();
    }

    public void handle2() {
        this.currentState.handle2();
    }
}
