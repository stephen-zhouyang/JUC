package com.zhou.pc;

public class A {
    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

//判断等待，业务，通知
class Data { // 资源类
    private int number = 1;

    //+1
    public synchronized void increment() throws InterruptedException {
        while (number != 0)
            this.wait();
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notify();
    }

    //-1
    public synchronized void decrement() throws InterruptedException {
        while (number == 0)
            this.wait();
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        this.notify();
    }

}












