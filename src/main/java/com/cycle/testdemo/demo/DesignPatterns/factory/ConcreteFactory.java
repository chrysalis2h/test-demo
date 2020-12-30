package com.cycle.testdemo.demo.DesignPatterns.factory;

/**
 * @ClassName: AbstractFactory$
 * @Description: AbstractFactory$
 * @Author: HJ
 * @Date: 2020/12/27$ 14:38$
 * @Version: v1.0 文件初始创建
 */
public class ConcreteFactory extends AbstractFactory {

    @Override
    public <T extends AbstractProduct> T createProduct(Class<T> c) {
        AbstractProduct product = null;
        try {
            product = (AbstractProduct) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
