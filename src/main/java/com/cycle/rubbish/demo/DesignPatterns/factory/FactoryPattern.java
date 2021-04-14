package com.cycle.rubbish.demo.DesignPatterns.factory;

/**
 * @ClassName: FactoryPattern$
 * @Description: FactoryPattern$
 * @Author: HJ
 * @Date: 2020/12/27$ 14:26$
 * @Version: v1.0 文件初始创建
 */
public class FactoryPattern {

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        AbstractProduct product = factory.createProduct(ConcreteProduct1.class);
        product.method1();
    }
}
