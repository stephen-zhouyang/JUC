package com.zhou.function;

import java.util.function.Consumer;

public class Demo03 {
    public static void main(String[] args) {
        Consumer<String> consumer = (str)->{ System.out.println(str);};
        consumer.accept("consumer测试");
    }
}
