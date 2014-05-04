package com.domac.concurrent.lock.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : lihaoquan
 *
 * 模拟10个人参加跑步比赛
 *
 * ************************
 * 参考资料:
 * http://www.itzhai.com/the-introduction-and-use-of-a-countdownlatch.html
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws Exception {

        final int count = 10;

        final CountDownLatch startLatch = new CountDownLatch(1);
        final CountDownLatch finishLatch = new CountDownLatch(count);

        ExecutorService executorService = Executors.newFixedThreadPool(count);

        for(int i = 1; i<=count;i++) {
            final int num = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        startLatch.await();
                        Thread.sleep((long) (Math.random()*10000));
                        System.out.println("第"+num+"号选手达到终点");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        finishLatch.countDown();
                    }
                }
            };
            executorService.execute(runnable);
        }

        System.out.println("比赛开始!");
        startLatch.countDown();
        finishLatch.await();
        System.out.println("比赛结束");
        executorService.shutdown();
    }
}
