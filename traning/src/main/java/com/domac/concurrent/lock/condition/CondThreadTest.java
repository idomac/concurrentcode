package com.domac.concurrent.lock.condition;

/**
 * @author : lihaoquan
 *
 * ********************************
 *  参考资料:
 *  http://blog.csdn.net/ghsau/article/details/7481142
 *  http://blog.csdn.net/ghsau/article/category/1707779
 *  http://my.oschina.net/leoson/blog/106452
 *  http://www.cnblogs.com/wn398/archive/2013/06/15/3130967.html
 */
public class CondThreadTest {

    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadExecute(business,"sub");
            }
        }).start();
        threadExecute(business,"main");
    }

    public static void threadExecute(Business business, String threadType) {
        for(int i = 0; i < 5; i++) {
            try {
                if("main".equals(threadType)) {
                    business.manFun(i);
                } else {
                    business.subFun(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
