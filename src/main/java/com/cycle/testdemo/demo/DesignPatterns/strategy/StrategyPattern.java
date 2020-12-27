package com.cycle.testdemo.demo.DesignPatterns.strategy;

/**
 * @ClassName: StrategyMain
 * @Description: StrategyMain
 * @Author: HeJin
 * @Date: 2020\12\3 0003 15:44
 * @Version: v1.0 文件初始创建
 */
public class StrategyPattern {

    public static void main(String[] args) {

        StrategyContext strategy = new StrategyContext();
        ConcreteStrategyAImpl strategyA = new ConcreteStrategyAImpl();

        strategy.setBaseThirdInterfaceStrategy(strategyA);

        strategy.validateParam();
        strategy.executeToCallThird();
        strategy.executeToQueryResult();


    }
}
