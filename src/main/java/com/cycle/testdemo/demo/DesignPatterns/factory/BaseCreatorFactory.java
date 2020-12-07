package com.cycle.testdemo.demo.DesignPatterns.factory;

/**
 * @ClassName: CreatorFactory
 * @Description: CreatorFactory
 * @Author: HeJin
 * @Date: 2020\12\7 0007 11:18
 * @Version: v1.0 文件初始创建
 */
public abstract class BaseCreatorFactory {

    public abstract <T extends BaseProduct> T createProduct(Class<T> c);
}
