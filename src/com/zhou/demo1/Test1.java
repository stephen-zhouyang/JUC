package com.zhou.demo1;


public class Test1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(()->{
            for (int i = 1 ; i <= 40 ;i++)
                ticket.sale();
        },"A").start();

        new Thread(()->{
            for (int i = 1 ; i <= 40 ;i++)
                ticket.sale();
        },"B").start();

        new Thread(()->{
            for (int i = 1 ; i <= 40 ;i++)
                ticket.sale();
        },"C").start();
    }
}
class Ticket{
    //属性、方法
    private int number = 30;

    //卖票的方式
    //synchronized 本质 ： 队列、锁
    public synchronized void sale(){
        if (number > 0)
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--
            ) + "票，剩余： " + number);
    }

}