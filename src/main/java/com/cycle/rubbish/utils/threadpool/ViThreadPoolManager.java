package com.cycle.rubbish.utils.threadpool;


/**
 * @Author: xiaobing
 * @Description: 当前类（子系统中定义的类）继承 ThreadPoolManager 类，设置相关参数
 * @Date: 2019/10/9
 */
public class ViThreadPoolManager extends ThreadPoolManager {
    private static ThreadPoolManager threadPool  = null;

    public synchronized static ThreadPoolManager getInstance() {
        if(threadPool == null) {
            threadPool = new ViThreadPoolManager();
        }
        return threadPool;
    }

    @Override
    protected String getThreadPoolName() {
        return "com.fantaike.template.util.threadpool";
    }

    @Override
    protected int corePoolSize() {
        /**
         * 代码 设置返回值
         */
        return 10;
    }

    @Override
    protected int maximumPoolSize() {
        /**
         * 代码 设置返回值
         */
        return 20;
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest();
        for(int i=0;i<1000; i++) {
            ViThreadPoolManager.getInstance().execute(t1);
        }
    }
}