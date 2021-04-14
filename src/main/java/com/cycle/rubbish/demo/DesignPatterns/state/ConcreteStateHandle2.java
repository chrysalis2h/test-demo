package com.cycle.rubbish.demo.DesignPatterns.state;

/**
 * @ClassName: ConcreteHandle2
 * @Description: ConcreteHandle2
 * @Author: HJ
 * @Date: 2021/1/12 20:56
 * @Version: v1.0 文件初始创建
 */
public class ConcreteStateHandle2 extends BaseState{

    @Override
    public void handle1() {
        //交由handle1去执行1
        System.out.println("交由handle1去执行1");
        super.stateContext.setCurrentState(StateContext.HANDLE1);
        super.stateContext.handle1();
    }

    @Override
    public void handle2() {
        System.out.println("执行handle2方法");
    }
}
