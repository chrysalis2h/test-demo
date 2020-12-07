package com.cycle.testdemo.demo.DesignPatterns.factory;

/**
 * @ClassName: ConcreteFactory
 * @Description: ConcreteFactory
 * @Author: HeJin
 * @Date: 2020\12\7 0007 15:02
 * @Version: v1.0 文件初始创建
 */
public class ConcreteFactory extends BaseCreatorFactory {

    @Override
    public <T extends BaseProduct> T createProduct(Class<T> c) {
        BaseProduct product = null;
        try {
            product = (T) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
