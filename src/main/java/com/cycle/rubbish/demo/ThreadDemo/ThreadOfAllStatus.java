package com.cycle.rubbish.demo.ThreadDemo;

public class ThreadOfAllStatus {

    public static void main(String[] args) {
        Thread t = new Thread(new MyTask());
        t.setName("");
        t.start();
        System.out.println("main thread end");
    }

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println("start");
            System.out.println("end");
        }
    }
}
