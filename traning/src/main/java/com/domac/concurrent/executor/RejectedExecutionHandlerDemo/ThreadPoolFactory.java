package com.domac.concurrent.executor.RejectedExecutionHandlerDemo;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * created by quanix
 *
 * 线程池工厂类
 */
public class ThreadPoolFactory {

    private static ThreadPoolExecutor threadPoolExecutor;

    private static ThreadPoolFactory threadPoolFactory;

    /**
     * 工厂类单例
     * @param threadPoolConfig
     * @return
     */
    public static ThreadPoolFactory getInstance(ThreadPoolConfig threadPoolConfig) {

        if(null == threadPoolFactory) {
            threadPoolFactory = new ThreadPoolFactory();
        }

        if(null == threadPoolExecutor) {
            if(threadPoolConfig.getHandler() == null) {
                threadPoolExecutor = new ThreadPoolExecutor(
                        threadPoolConfig.getCorePoolSize(),
                        threadPoolConfig.getMaximumPoolSize(),
                        threadPoolConfig.getKeepAliveTime(),
                        threadPoolConfig.getUnit(),
                        threadPoolConfig.getWorkQueue());
            }else {
                threadPoolExecutor = new ThreadPoolExecutor(
                        threadPoolConfig.getCorePoolSize(),
                        threadPoolConfig.getMaximumPoolSize(),
                        threadPoolConfig.getKeepAliveTime(),
                        threadPoolConfig.getUnit(),
                        threadPoolConfig.getWorkQueue(),
                        threadPoolConfig.getHandler());
            }
        }
        System.out.println("pool  create= "+threadPoolExecutor.toString());
        return threadPoolFactory;
    }

    /**
     * 添加任务
     * @param runnableTask
     */
    public synchronized void addTask(Runnable runnableTask) {
        threadPoolExecutor.execute(runnableTask);
    }

    public void addTask(List<Runnable> runnables) {
        if(null != runnables) {
            for(Runnable r : runnables) {
                threadPoolExecutor.execute(r);
            }
        }
    }

    /**
     * 关闭线程池
     */
    public void closePool() {
        threadPoolExecutor.shutdown();
    }
}
