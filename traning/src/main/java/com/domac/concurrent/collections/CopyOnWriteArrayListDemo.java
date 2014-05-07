package com.domac.concurrent.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : lihaoquan
 */
public class CopyOnWriteArrayListDemo {


    static class ReadTask implements Runnable {

        List<String> list;

        ReadTask(List<String> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for(String s: list) {
                System.out.println(s);
            }
        }
    }

    static class WriteTask implements Runnable {

        List<String> list;
        int index;

        WriteTask(List<String> list,int index) {
            this.list = list;
            this.index = index;
        }

        @Override
        public void run() {
            list.remove(index);
            list.add(index, "write_" + index);

        }
    }


    public void run() {
        final int _num = 10;
        //List<String> list = new ArrayList<String>();//会抛出ConcurrentModificationException
        List<String> list = new CopyOnWriteArrayList<String>();
        for(int i = 0; i<_num;i++) {
            list.add("main_"+i);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(_num);
        try {
            for(int i = 0; i< _num;i++) {
                executorService.execute(new ReadTask(list));
                executorService.execute(new WriteTask(list,i));
            }
        }finally {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) throws Exception {
        new CopyOnWriteArrayListDemo().run();
    }

}
