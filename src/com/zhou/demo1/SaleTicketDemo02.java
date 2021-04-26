package com.zhou.demo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
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

class Ticket2{
    private int number = 30;
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if (number > 0)
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--
                ) + "票，剩余： " + number);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}









