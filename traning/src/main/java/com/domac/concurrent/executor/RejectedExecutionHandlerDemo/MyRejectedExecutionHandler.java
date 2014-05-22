package com.domac.concurrent.executor.RejectedExecutionHandlerDemo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * created by quanix
 *
 * 线程异常处理类
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable runnableTask, ThreadPoolExecutor executor) {

        System.out.println("异常处理器开始......");
        new Thread(runnableTask).start();
        System.out.println("The Pool RejectedExecutionHandler = "+executor.toString());
    }
}
