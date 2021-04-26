package com.zhou.function;

import java.util.function.Predicate;

public class Demo02 {
    public static void main(String[] args) {
        Predicate<String> predicate = (str)->{return str.isEmpty();};
        System.out.println(predicate.test("fasf"));
    }
}
