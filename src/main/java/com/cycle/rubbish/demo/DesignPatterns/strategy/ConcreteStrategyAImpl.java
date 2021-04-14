package com.cycle.rubbish.demo.DesignPatterns.strategy;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: StragegyAImpl
 * @Description: StragegyAImpl
 * @Author: HeJin
 * @Date: 2020\12\3 0003 15:42
 * @Version: v1.0 文件初始创建
 */
public class ConcreteStrategyAImpl implements BaseThirdInterfaceStrategy {

    @Override
    public JSONObject validateParam() {
        System.out.println("validateParam concrete strategy a ");
        return null;
    }

    @Override
    public JSONObject executeToCallThird() {
        System.out.println("executeToCallThird concrete strategy a ");
        return null;
    }

    @Override
    public JSONObject executeToQueryResult() {
        System.out.println("executeToQueryResult concrete strategy a ");
        return null;
    }
}
