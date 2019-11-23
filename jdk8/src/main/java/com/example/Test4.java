package com.example;

import java.util.function.Function;

/**
 * @author LinYongJin
 * @date 2019/11/23 20:09
 */
public class Test4 {

    public Integer compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public static void main(String[] args) {
        System.out.println(new Test4().compute(4, value -> value * value));
        System.out.println(new Test4().compute(5, value -> value + 10));
    }
}
