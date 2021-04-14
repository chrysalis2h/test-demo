package com.cycle.rubbish.demo.DesignPatterns.templatemethod;

/**
 * @ClassName: SingletonPattern$
 * @Description: SingletonPattern$
 * @Author: HJ
 * @Date: 2020/12/27$ 14:25$
 * @Version: v1.0 文件初始创建
 */
public class TemplateMethonPattern {

    public static void main(String[] args) {
        AbstractTemplate template = new ConcreteTemplate();
        template.templateMethond();
    }
}
