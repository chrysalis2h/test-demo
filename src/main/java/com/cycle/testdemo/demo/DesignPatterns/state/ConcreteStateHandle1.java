package com.cycle.testdemo.demo.DesignPatterns.state;

/**
 * @ClassName: ConcreteHandle1
 * @Description: 具体的状态角色--完成如下两个任务：1、当前方法的执行；2、状态的切换。
 * @Author: HJ
 * @Date: 2021/1/12 20:56
 * @Version: v1.0 文件初始创建
 */
public class ConcreteStateHandle1 extends BaseState {

    @Override
    public void handle1() {
        System.out.println("执行handle1方法");
    }

    /**
     * @param
     * @Description: 完成状态的切换，由对应状态做处理
     * @Date: 2021/1/12 21:12
     * @Author: HJ
     * @Return
     * @Throws
     */
    @Override
    public void handle2() {
        System.out.println("交由handle2去执行2");
        super.stateContext.setCurrentState(StateContext.HANDLE2);
        super.stateContext.handle2();
    }
}
