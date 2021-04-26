package com.zhou.lock8;

import java.util.concurrent.TimeUnit;
/**
 * 1、1个静态的同步方法，1个普通的同步方法 ，一个对象，先打印 发短信？打电话？
 * 2、1个静态的同步方法，1个普通的同步方法 ，两个对象，先打印 发短信？打电话？ 优先级一样，谁抢到是谁的
 */
public class Test3 {
    public static void main(String[] args) {
// 两个对象的Class类模板只有一个，static，锁的是Class
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();
//锁的存在
        new Thread(()->{
            phone1.sendSms();
        },"A").start();
// 捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            phone2.call();
        },"B").start();
    }
}
class Phone3{
    // 静态的同步方法 锁的是 Class 类模板
    public static synchronized void sendSms(){

        System.out.println("发短信");
    }
    // 普通的同步方法 锁的调用者
    public synchronized void call(){
        try {TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("打电话");
    }
}