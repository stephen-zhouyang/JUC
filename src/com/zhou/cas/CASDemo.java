package com.zhou.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(199);

        System.out.println(atomicInteger.compareAndSet(199,205));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(205,199));
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(199,1));
        System.out.println(atomicInteger.get());

    }
}
