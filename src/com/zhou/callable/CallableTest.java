package com.zhou.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask futureTask = new FutureTask<>(myThread);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start();
        Integer o = (Integer) futureTask.get();
        System.out.println(o);
    }
}

class MyThread implements Callable<Integer>{

    @Override
    public Integer call()  {
        System.out.println("call()");
        return 1024;
    }
}

