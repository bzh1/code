package com.atguigu;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockA+"\t 尝试或得"+lockB);

            try { TimeUnit.MILLISECONDS.sleep( 100 ); } catch (InterruptedException e) { e.printStackTrace(); }

            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName()+"\t 自己持有"+lockB+"\t 尝试或得"+lockA);
            }
        }
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new HoldLockThread(lockA,lockB),"AAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"BBB").start();
    }
}
