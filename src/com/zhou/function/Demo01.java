package com.zhou.function;

import java.util.function.Function;

public class Demo01 {
    public static void main(String[] args) {
        Function<String, String> function = (str)->{return str;};
        System.out.println(function.apply("afaf"));
    }
}
