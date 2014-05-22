package com.domac.concurrent.executor.RejectedExecutionHandlerDemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;

/**
 * created by quanix
 */
public class ThreadPoolConfig {

    private int corePoolSize; //池中所保存的线程数，包括空闲线程。
    private int maximumPoolSize;//池中允许的最大线程数。
    private long keepAliveTime; //当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
    private TimeUnit unit;//参数的时间单位。
    private BlockingQueue<Runnable> workQueue;//执行前用于保持任务的队列。此队列仅由保持 execute 方法提交的 Runnable 任务。
    private RejectedExecutionHandler handler; //由于超出线程范围和队列容量而使执行被阻塞时所使用的处理程序。


    private static ThreadPoolConfig config;
    public static ThreadPoolConfig getInstance() {
        if(config == null) {
            config = new ThreadPoolConfig();
        }
        return config;
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public long getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public BlockingQueue<Runnable> getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
    }

    public RejectedExecutionHandler getHandler() {
        return handler;
    }

    public void setHandler(RejectedExecutionHandler handler) {
        this.handler = handler;
    }
}
