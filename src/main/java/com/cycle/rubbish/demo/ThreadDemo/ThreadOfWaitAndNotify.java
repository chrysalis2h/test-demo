package com.cycle.rubbish.demo.ThreadDemo;

public class ThreadOfWaitAndNotify {

    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                //获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        // 创建线程
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                //获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
                    resourceA.notifyAll();
                }
            }
        });
        System.out.println("threadA start");
        threadA.start();
        System.out.println("threadB start");
        threadB.start();

        System.out.println("thread sleep");
        Thread.sleep(1000);
        System.out.println("threadC start");
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
        /*
        threadA start
        threadA get resourceA lock
        threadA begin wait
        threadB start
        threadB get resourceA lock
        threadB begin wait
        thread sleep
        threadC start
        threadC begin notify


         */
    }
}
