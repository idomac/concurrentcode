package com.domac.concurrent.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : lihaoquan
 */
public class Business {

    private boolean bool = true;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    /**
     * 主方法
     */
    public void manFun(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (bool) {
                condition.await();//this.wait();
            }

            for(int i = 0; i< 100; i++) {
                System.out.println("main thread seq of " + i + ", loop of " + loop);
            }
            bool = true;
            condition.signal();//this.notify();
        }finally {
            lock.unlock();
        }
    }

    /**
     * 子方法
     */
    public void subFun(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (!bool) {
                condition.await();//this.wait;
            }

            for(int i = 0; i<10;i++) {
                System.out.println("sub thread seq of " + i + ", loop of " + loop);
            }
            bool = false;
            condition.signal();//this.notify()
        }finally {
            lock.unlock();
        }
    }
}
