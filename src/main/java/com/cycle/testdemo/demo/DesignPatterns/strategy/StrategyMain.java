package com.cycle.testdemo.demo.DesignPatterns.strategy;

import com.cycle.testdemo.api.designpattern.strategy.ContextOfStrategy;

/**
 * @ClassName: StrategyMain
 * @Description: StrategyMain
 * @Author: HeJin
 * @Date: 2020\12\3 0003 15:44
 * @Version: v1.0 文件初始创建
 */
public class StrategyMain {

    public static void main(String[] args) {

        ContextOfStrategy strategy = new ContextOfStrategy();
        ConcreteStrategyAImpl strategyA = new ConcreteStrategyAImpl();

        strategy.setBaseThirdInterfaceStrategy(strategyA);

        strategy.validateParam();
        strategy.executeToCallThird();
        strategy.executeToQueryResult();


    }
}
