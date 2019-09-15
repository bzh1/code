package com.atguigu;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    volatile int numble = 0;

    public void addTo60() {
        this.numble = 60;
    }

    public void addPlusPlus() {
        numble++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyatomic() {

        atomicInteger.getAndIncrement();
    }
}


/**volatile的三大特性
 *      1、保证可见性
 *      2、不保证原子性
 *          解决方法：1）使用sychronized。不使用  2）使用juc的AtomicInteger
 *      3、禁止指令重排
 */

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyatomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int type" + myData.numble);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type" + myData.atomicInteger);
        System.out.println(System.getProperties());
    }

    private static void seeOkByVolatile() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in ");
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + " come in " + myData.numble);


        }, "A").start();

        while (myData.numble == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t main come in " + myData.numble);
    }
}
