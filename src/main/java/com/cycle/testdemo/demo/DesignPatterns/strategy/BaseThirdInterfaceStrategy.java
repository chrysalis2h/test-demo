package com.cycle.testdemo.demo.DesignPatterns.strategy;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName:
 * @Description: 
 * @Author: HJ
 * @Date: 2020\12\3 0003 15:09
 * @Version: v1.0 文件初始创建
 */
public interface BaseThirdInterfaceStrategy {
    JSONObject validateParam();
    JSONObject executeToCallThird();
    JSONObject executeToQueryResult();
}
