package com.zhou.function;

import java.util.function.Supplier;

public class Demo04 {
    public static void main(String[] args) {
        Supplier supplier = ()->{return 1024;};
        System.out.println(supplier.get());
    }
}