package com.domac.concurrent.executor.RejectedExecutionHandlerDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * created by quanix
 */
public class RejectTest {

    public static void main(String[] args) throws Exception {
        ThreadPoolConfig threadPoolConfig = new ThreadPoolConfig();
        threadPoolConfig.setCorePoolSize(2);
        threadPoolConfig.setMaximumPoolSize(3);
        threadPoolConfig.setKeepAliveTime(5);
        threadPoolConfig.setUnit(TimeUnit.SECONDS);
        threadPoolConfig.setWorkQueue(new ArrayBlockingQueue<Runnable>(10));
        threadPoolConfig.setHandler(new MyRejectedExecutionHandler());

        ThreadPoolFactory threadPoolExecutor = ThreadPoolFactory.getInstance(threadPoolConfig);
        for(int i = 0; i<100;i++) {
           threadPoolExecutor.addTask(new ThreadTask(i+"-i"));
        }

        System.out.println("i add is over!-------------------");

    }
}
