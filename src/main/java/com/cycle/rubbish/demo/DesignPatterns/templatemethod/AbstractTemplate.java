package com.cycle.rubbish.demo.DesignPatterns.templatemethod;

/**
 * @ClassName: AbstractTemplate$
 * @Description: AbstractTemplate$
 * @Author: HJ
 * @Date: 2020/12/27$ 14:43$
 * @Version: v1.0 文件初始创建
 */
public abstract class AbstractTemplate {
    protected abstract void doSomething();

    protected abstract void doAnything();

    public void templateMethond() {
        this.doSomething();
        this.doAnything();
    }
}
