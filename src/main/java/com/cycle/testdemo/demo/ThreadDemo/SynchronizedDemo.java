package com.cycle.testdemo.demo.ThreadDemo;

/**
 * @ClassName: SynchronizedDemo
 * @Description: Synchronized 分为对象锁 类锁
 * https://blog.csdn.net/yhl_jxy/article/details/87012803
 * @Author: HeJin
 * @Date: 2021\3\31 0031 15:55
 * @Version: v1.0 文件初始创建
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        Task taskA = new Task();
        Task taskB = new Task();
        Thread a1 = new ThreadA(taskA);
        Thread a2 = new ThreadB(taskB);
        Thread b1 = new ThreadA(taskA);
        Thread b2 = new ThreadB(taskB);

        a1.setName("A1");
        a2.setName("A2");
        b1.setName("B1");
        b2.setName("B2");

        a1.start();
//        a2.start();
        b1.start();
//        b2.start();
    }

    public static class Task {
        public synchronized void doSomethingA() {
            System.out.println("name = " + Thread.currentThread().getName() + ", begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("name = " + Thread.currentThread().getName() + ", end");
        }

        public void doSomethingB() {
            synchronized (this) {
                System.out.println("name = " + Thread.currentThread().getName() + ", begin");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("name = " + Thread.currentThread().getName() + ", end");
            }
        }
    }

    public static class ThreadA extends Thread {
        private Task task;

        public ThreadA(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            task.doSomethingA();
        }
    }

    public static class ThreadB extends Thread {
        private Task task;

        public ThreadB(Task task) {
            this.task = task;
        }

        @Override
        public void run() {
            task.doSomethingB();
        }
    }

}
