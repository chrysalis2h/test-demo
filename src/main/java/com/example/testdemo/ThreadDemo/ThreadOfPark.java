package com.example.testdemo.ThreadDemo;

import java.util.concurrent.locks.LockSupport;

public class ThreadOfPark {

    private static volatile Object resourceA = new Object();

    /**
     * 1、直接调用park，阻塞
     * 2、直接调用unpark，获取许可证
     * 3、调用unpark，再调用park，立即返回
     *
     * 调用park方法，被其他线程中断，不会抛出interruptedException
     */

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new MyTask());
        t.start();
        Thread.sleep(1000);
        LockSupport.unpark(t);
        System.out.println("main thread end");
    }

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println("park start");
//            LockSupport.park();
            System.out.println("park end");
        }
    }
}
