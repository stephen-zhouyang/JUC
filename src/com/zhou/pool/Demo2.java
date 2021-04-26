package com.zhou.pool;

import java.util.concurrent.*;

public class Demo2 {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(2
        ,5
        ,3
        , TimeUnit.SECONDS
        ,new LinkedBlockingDeque<>(3)
        , Executors.defaultThreadFactory()
        ,new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 1; i <= 9 ; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
