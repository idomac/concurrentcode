package com.domac.concurrent.executor.RejectedExecutionHandlerDemo;

/**
 * created by quanix
 */
public class ThreadTask implements Runnable {

    private String name;

    public ThreadTask(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        System.out.println(this.name +" thread will sleep 0 s");
        try {

            Thread.sleep(1*10);

        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(this.name +"I am wakeup now ");
    }
}
