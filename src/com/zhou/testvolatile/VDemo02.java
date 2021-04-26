package com.zhou.testvolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class VDemo02 {
    private  static AtomicInteger num = new AtomicInteger();
    public static  void add(){
        num.getAndIncrement();
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 20 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " " + num);
    }

}
