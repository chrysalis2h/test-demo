package com.cycle.rubbish.utils.threadpool;

/**
 * @Description:
 * @Author: xiaobing
 * @system name: 新一代金融消费系统
 * @copyright：长安新生（深圳）金融投资有限公司
 * @Date: Created in  2019/10/9 21:51
 */
public class ThreadTest implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
