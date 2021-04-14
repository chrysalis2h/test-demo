package com.cycle.rubbish.demo.DesignPatterns.strategy;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName: ContextOfStrategy
 * @Description: ContextOfStrategy
 * @Author: HeJin
 * @Date: 2020\12\3 0003 15:45
 * @Version: v1.0 文件初始创建
 */
public class StrategyContext {

    private BaseThirdInterfaceStrategy baseThirdInterfaceStrategy;

    public BaseThirdInterfaceStrategy getBaseThirdInterfaceStrategy() {
        return baseThirdInterfaceStrategy;
    }

    public void setBaseThirdInterfaceStrategy(BaseThirdInterfaceStrategy baseThirdInterfaceStrategy) {
        this.baseThirdInterfaceStrategy = baseThirdInterfaceStrategy;
    }

    /**
     * 策略抽象类的具体方法
     */
    public JSONObject validateParam() {
        return this.baseThirdInterfaceStrategy.validateParam();
    }

    public JSONObject executeToCallThird() {
        return this.baseThirdInterfaceStrategy.executeToCallThird();
    }

    public JSONObject executeToQueryResult() {
        return this.baseThirdInterfaceStrategy.executeToQueryResult();
    }

}
