package com.domac.concurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author : lihaoquan
 */
public class ExecutorServiceTest {

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i = 0; i<10;i++) {
            System.out.println("创建线程" + i);
            MyRum runnable = new MyRum();
            executorService.execute(runnable);
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("all thread complete");
    }

    static class MyRum implements Runnable {
        @Override
        public void run() {
            System.out.println("启动线程");
        }
    }
}
