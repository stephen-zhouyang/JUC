package com.zhou.lock8;

import java.util.concurrent.TimeUnit;

public class Test1 {
    // 8锁，就是关于锁的8个问题
    //1、标准情况下，两个线程先打印 发短信 还是 打电话？
    //1、sendSms延迟4秒，两个线程先打印 发短信还是 打电话？ 发短信
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();
    }
}

class Phone{
    public synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call(){
        System.out.println("打电话");
    }
}






